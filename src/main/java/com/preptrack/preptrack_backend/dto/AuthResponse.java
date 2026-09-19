

package com.preptrack.preptrack_backend.dto;

public record AuthResponse(
        String token,
        String message
) {
}