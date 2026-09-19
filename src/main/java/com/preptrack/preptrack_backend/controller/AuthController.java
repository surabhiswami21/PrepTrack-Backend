package com.preptrack.preptrack_backend.controller;

import com.preptrack.preptrack_backend.dto.AuthResponse;
import com.preptrack.preptrack_backend.dto.LoginRequest;
import com.preptrack.preptrack_backend.dto.RegisterRequest;
import com.preptrack.preptrack_backend.service.AuthService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}