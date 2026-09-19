package com.preptrack.preptrack_backend.service;

import com.preptrack.preptrack_backend.dto.AuthResponse;
import com.preptrack.preptrack_backend.dto.LoginRequest;
import com.preptrack.preptrack_backend.dto.RegisterRequest;
import com.preptrack.preptrack_backend.entity.User;
import com.preptrack.preptrack_backend.repository.UserRepository;
import com.preptrack.preptrack_backend.security.JwtService;
import com.preptrack.preptrack_backend.security.UserPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        // Password ko BCrypt se hash karenge
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        String storedPassword = user.getPassword();

        boolean matches;

        // New users -> BCrypt password
        if (storedPassword != null && storedPassword.startsWith("$2")) {

            matches = passwordEncoder.matches(
                    request.getPassword(),
                    storedPassword
            );

        } else {

            // Old users ke liye plain-text compatibility
            matches = storedPassword != null
                    && storedPassword.equals(request.getPassword());

            // Successful login ke baad old password ko BCrypt mein convert
            if (matches) {

                user.setPassword(
                        passwordEncoder.encode(request.getPassword())
                );

                userRepository.save(user);
            }
        }

        if (!matches) {
            throw new RuntimeException("Invalid Password");
        }

        // JWT generate
        String token = jwtService.generateToken(
                new UserPrincipal(user)
        );

        return new AuthResponse(
                token,
                "Login Successful"
        );
    }
}