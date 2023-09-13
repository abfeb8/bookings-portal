package com.abfeb8.app.booking.users.dto;

public record UserRegistrationRequest(
        String firstName,
        String lastName,
        String email,
        String username,
        String password
) {}
