package com.abfeb8.app.users.dto;

public record RegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String username,
        String password
) {
}
