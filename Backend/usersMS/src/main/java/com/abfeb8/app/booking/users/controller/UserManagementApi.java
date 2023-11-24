package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.*;
import org.springframework.http.ResponseEntity;

public interface UserManagementApi {

    // User Registration
    ResponseEntity<UserAuthenticationResponse> registerUser(UserRegistrationRequest registrationRequest);

    // User Profile
    ResponseEntity<UserProfile> getUserProfile(String username);

    // Update Profile
    ResponseEntity<UserProfile> updateUserProfile(String username, UserProfileUpdateRequest updateRequest);

    // Password Reset
    ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest);

}
