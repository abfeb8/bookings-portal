package com.abfeb8.app.users.dto;

public record LoginRequest(
        String username,
        String password
) {
}
