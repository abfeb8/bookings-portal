package com.abfeb8.app.booking.users.dto;

public record PasswordResetRequest(
        String email,
        String oldPassword,
        String newPassword
) {
}
