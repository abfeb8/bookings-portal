package com.abfeb8.app.booking.users.enums;

public enum UserRole {
    ROLE_USER("User"),
    ROLE_ADMIN("Admin");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

