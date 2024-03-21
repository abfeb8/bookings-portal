package com.abfeb8.app.booking.users.dto;

import com.abfeb8.app.booking.users.entity.UserEntity;
import lombok.Builder;

@Builder
public record UserDto(
        Long userId,
        String firstName,
        String lastName,
        String email,
        String username,
        String phoneNumber,
        String address
        // Other user profile information
) {
    public static UserDto convertToUserProfile(UserEntity userEntity) {
        return UserDto.builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .userId(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getContact().getEmail())
                .phoneNumber(userEntity.getContact().getPhoneNumber())
                .build();
    }
}