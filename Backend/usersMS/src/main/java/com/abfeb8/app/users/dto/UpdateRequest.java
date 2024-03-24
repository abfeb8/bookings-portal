package com.abfeb8.app.users.dto;

public record UpdateRequest(
        String phoneNumber,
        String address
        // Other fields for updating the profile
) {
}
