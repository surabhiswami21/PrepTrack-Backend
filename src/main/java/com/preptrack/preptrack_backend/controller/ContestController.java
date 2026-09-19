package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.entity.Contest;
import com.preptrack.preptrack_backend.service.ContestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ContestController {

    private final ContestService contestService;
    private final UserRepository userRepository;

    public ContestController(
            ContestService contestService, UserRepository userRepository
    ) {
        this.contestService = contestService;
        this.userRepository = userRepository;
    }
    private User user(Principal principal) { return userRepository.findByEmail(principal.getName()).orElseThrow(); }

    @PostMapping("/api/contest/save")
    public Contest save(
            @RequestBody Contest contest, Principal principal
    ) {
        return contestService.save(contest, user(principal));
    }

    @GetMapping("/api/contest/all")
    public List<Contest> getAll(Principal principal) {
        return contestService.getAll(user(principal));
    }

    @DeleteMapping("/api/contest/delete/{id}")
    public void delete(
            @PathVariable Long id, Principal principal
    ) {
        contestService.delete(id, user(principal));
    }
}
