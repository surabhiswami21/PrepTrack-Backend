package com.preptrack.preptrack_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey secretKey;

    private final long expirationMs;

    public JwtService(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration-ms:86400000}") long expirationMs) {

        if (secret == null ||
                secret.getBytes(StandardCharsets.UTF_8).length < 32) {

            throw new IllegalArgumentException(
                    "jwt.secret must be at least 32 characters long"
            );
        }

        this.secretKey =
                Keys.hmacShaKeyFor(
                        secret.getBytes(StandardCharsets.UTF_8)
                );

        this.expirationMs = expirationMs;
    }

    public String generateToken(UserPrincipal user) {

        Date now = new Date();

        return Jwts.builder()

                .subject(user.getUsername())

                .claim("userId", user.getId())

                .claim("name", user.getName())

                .issuedAt(now)

                .expiration(
                        new Date(
                                now.getTime() + expirationMs
                        )
                )

                .signWith(secretKey)

                .compact();
    }

    public String extractUsername(String token) {

        return parseClaims(token).getSubject();
    }

    public boolean isTokenValid(String token) {

        try {

            parseClaims(token);

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private Claims parseClaims(String token) {

        return Jwts.parser()

                .verifyWith(secretKey)

                .build()

                .parseSignedClaims(token)

                .getPayload();
    }
}