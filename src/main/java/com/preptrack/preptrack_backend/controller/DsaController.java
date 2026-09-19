package com.preptrack.preptrack_backend.controller;
import java.util.List;
import com.preptrack.preptrack_backend.entity.DsaProgress;
import com.preptrack.preptrack_backend.service.DsaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;
@RestController
public class DsaController {

    private final DsaService dsaService;
    private final UserRepository userRepository;

    public DsaController(DsaService dsaService, UserRepository userRepository) {
        this.dsaService = dsaService;
        this.userRepository = userRepository;
    }
    private User user(Principal principal) { return userRepository.findByEmail(principal.getName()).orElseThrow(); }
    @GetMapping("/test")
    public String test() {
        return "Working";
    }

    @GetMapping("/api/dsa/count")
    public int getCount(Principal principal) {
        return dsaService.getSolvedQuestions(user(principal));
    }


    @PostMapping("/api/dsa/save")
    public DsaProgress saveProgress(
            @RequestBody DsaProgress progress, Principal principal) {

        System.out.println("Easy = " + progress.getEasy());
        System.out.println("Medium = " + progress.getMedium());
        System.out.println("Hard = " + progress.getHard());

        return dsaService.save(progress, user(principal));
    }
    @GetMapping("/api/dsa/progress")
    public List<DsaProgress> getProgress(Principal principal) {
        return dsaService.getAllProgress(user(principal));
    }

    @DeleteMapping("/api/dsa/delete/{id}")
    public void deleteProgress(@PathVariable Long id, Principal principal) {
        dsaService.deleteProgress(id, user(principal));
    }

    @PutMapping("/api/dsa/update/{id}")
    public DsaProgress updateProgress(
            @PathVariable Long id,
            @RequestBody DsaProgress progress, Principal principal) {

        return dsaService.updateProgress(id, progress, user(principal));
    }

    @GetMapping("/api/dsa/streak")
    public int getStreak(Principal principal) {

        return dsaService.getStreak(user(principal));
    }

}