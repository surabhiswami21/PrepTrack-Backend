package com.preptrack.preptrack_backend.controller;
import com.preptrack.preptrack_backend.entity.RevisionProgress;

import com.preptrack.preptrack_backend.repository.RevisionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;

@RestController
@RequestMapping("/api/revision")
@CrossOrigin(origins = "http://localhost:5173")
public class RevisionController {

    @Autowired
    private RevisionRepository repo;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/save")
    public RevisionProgress save(
            @RequestBody RevisionProgress revision, Principal principal) {

        revision.setUser(user(principal));
        return repo.save(revision);
    }

    @GetMapping("/all")
    public List<RevisionProgress> getAll(Principal principal) {

        User user = user(principal);
        return repo.findAllByUserOrderByIdAsc(user);
    }

    private User user(Principal principal) { return userRepository.findByEmail(principal.getName()).orElseThrow(); }
}
