package com.abfeb8.app.booking.users.dto;

public record UserLoginRequest(
        String username,
        String password
) {}
