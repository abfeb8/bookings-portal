package com.abfeb8.app.users.dto;

public record PasswordResetRequest(
        String email,
        String oldPassword,
        String newPassword
) {
}
