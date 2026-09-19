package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.dto.StatisticsResponse;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;
import com.preptrack.preptrack_backend.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final StatisticsService statisticsService;
    private final UserRepository userRepository;

    public StatisticsController(StatisticsService statisticsService, UserRepository userRepository) {
        this.statisticsService = statisticsService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public StatisticsResponse get(Principal principal) {
        User user = userRepository.findByEmail(principal.getName()).orElseThrow();
        return statisticsService.get(user);
    }
}
