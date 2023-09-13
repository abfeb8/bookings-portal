package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.*;
import com.abfeb8.app.booking.users.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class UserManagementController implements UserApiInterface {

    private final UserService userService;


    @Override
    public ResponseEntity<String> registerUser(UserRegistrationRequest registrationRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UserAuthenticationResponse> loginUser(UserLoginRequest loginRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UserProfile> getUserProfile(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<UserProfile> updateUserProfile(Long userId, UserProfileUpdateRequest updateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest) {
        return null;
    }

    @Override
    public ResponseEntity<String> logoutUser(String authToken) {
        return null;
    }
}
