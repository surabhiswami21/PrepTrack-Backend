package com.preptrack.preptrack_backend.controller;
import com.preptrack.preptrack_backend.entity.SqlProgress;
import com.preptrack.preptrack_backend.repository.SqlProgressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/sql")
@CrossOrigin(origins = "http://localhost:5173")
public class SqlProgressController {

    private final SqlProgressRepository repo;
    private final UserRepository userRepository;

    public SqlProgressController(SqlProgressRepository repo, UserRepository userRepository) {
        this.repo = repo;
        this.userRepository = userRepository;
    }

    private User user(Principal principal) { return userRepository.findByEmail(principal.getName()).orElseThrow(); }

    @PostMapping("/save")
    public SqlProgress save(
            @RequestBody SqlProgress progress, Principal principal) {

        progress.setUser(user(principal));
        return repo.save(progress);
    }

    @GetMapping("/all")
    public List<SqlProgress> getAll(Principal principal) {
        User user = user(principal);
        return repo.findAllByUserOrderByIdAsc(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id, Principal principal) {

        SqlProgress row = repo.findById(id).orElseThrow();
        if (row.getUser() == null) throw new org.springframework.security.access.AccessDeniedException("Unassigned legacy SQL progress requires migration");
        if (!user(principal).getId().equals(row.getUser().getId())) throw new org.springframework.security.access.AccessDeniedException("SQL progress does not belong to the authenticated user");
        repo.delete(row);

    }
}
