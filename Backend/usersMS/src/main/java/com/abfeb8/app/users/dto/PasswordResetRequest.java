package com.abfeb8.app.users.dto;

public record PasswordResetRequest(
        String username,
        String oldPassword,
        String newPassword
) {
}
