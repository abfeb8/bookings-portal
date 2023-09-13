package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.*;
import org.springframework.http.ResponseEntity;

public interface UserApiInterface {

    // User Registration
    ResponseEntity<String> registerUser(UserRegistrationRequest registrationRequest);

    // User Login
    ResponseEntity<UserAuthenticationResponse> loginUser(UserLoginRequest loginRequest);

    // User Profile
    ResponseEntity<UserProfile> getUserProfile(Long userId);

    ResponseEntity<UserProfile> updateUserProfile(Long userId, UserProfileUpdateRequest updateRequest);

    // Password Reset
    ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest);

    // Logout
    ResponseEntity<String> logoutUser(String authToken);
}
