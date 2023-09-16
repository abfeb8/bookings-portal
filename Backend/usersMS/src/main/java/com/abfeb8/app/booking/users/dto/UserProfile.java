package com.abfeb8.app.booking.users.dto;

import com.abfeb8.app.booking.users.entity.UserEntity;
import lombok.Builder;

@Builder
public record UserProfile(
        Long userId,
        String firstName,
        String lastName,
        String email,
        String username,
        String phoneNumber,
        String address
        // Other user profile information
) {
    public static UserProfile convertToUserProfile(UserEntity userEntity) {
        return UserProfile.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .userId(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }
}