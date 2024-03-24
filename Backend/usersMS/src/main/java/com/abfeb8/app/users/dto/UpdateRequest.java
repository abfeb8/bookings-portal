package com.abfeb8.app.users.dto;

public record UpdateRequest(
        String username,
        String oldPassword,
        String newPassword,
        String phoneNumber,
        String address
        // Other fields for updating the profile
) {
}
