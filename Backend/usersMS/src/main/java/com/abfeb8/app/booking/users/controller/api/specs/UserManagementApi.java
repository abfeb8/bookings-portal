package com.abfeb8.app.booking.users.controller.api.specs;

import com.abfeb8.app.booking.users.dto.PasswordResetRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UpdateRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserManagementApi {

    // User Registration
    ResponseEntity<UserDto> registerUser(RegistrationRequest registrationRequest);

    // User Profile
    ResponseEntity<UserDto> getUserProfile(String username);

    // Update Profile
    ResponseEntity<UserDto> updateUserProfile(String username, UpdateRequest updateRequest);

    // Password Reset
    ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest);

}
