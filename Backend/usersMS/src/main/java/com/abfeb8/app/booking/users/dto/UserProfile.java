package com.abfeb8.app.booking.users.dto;

public record UserProfile(
        Long userId,
        String firstName,
        String lastName,
        String email,
        String username,
        String phoneNumber,
        String address
        // Other user profile information
) {}