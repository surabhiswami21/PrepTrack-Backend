package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.entity.Job;
import com.preptrack.preptrack_backend.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.security.Principal;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class JobController {

    private final JobService jobService;
    private final UserRepository userRepository;

    public JobController(JobService jobService, UserRepository userRepository) {
        this.jobService = jobService;
        this.userRepository = userRepository;
    }
    private User user(Principal principal) { return userRepository.findByEmail(principal.getName()).orElseThrow(); }

    @PostMapping("/api/jobs/save")
    public Job save(@RequestBody Job job, Principal principal) {
        return jobService.save(job, user(principal));
    }

    @GetMapping("/api/jobs/all")
    public List<Job> getAll(Principal principal) {
        return jobService.getAll(user(principal));
    }

    @DeleteMapping("/api/jobs/delete/{id}")
    public void delete(@PathVariable Long id, Principal principal) {
        jobService.delete(id, user(principal));
    }
}