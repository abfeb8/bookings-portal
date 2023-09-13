package com.abfeb8.app.booking.users.dto;

public record UserAuthenticationResponse(
        String authToken,
        Long userId
) {}
