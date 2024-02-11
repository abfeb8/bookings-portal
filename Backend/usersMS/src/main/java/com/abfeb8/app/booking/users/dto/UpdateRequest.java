package com.abfeb8.app.booking.users.dto;

public record UpdateRequest(
        String firstName,
        String lastName,
        String phoneNumber,
        String address
        // Other fields for updating the profile
) {}
