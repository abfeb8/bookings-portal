package com.abfeb8.app.users.controller.api.specs;

import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UpdateRequest;
import com.abfeb8.app.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserManagementApi {

    // User Registration
    ResponseEntity<UserDto> registerUser(RegistrationRequest registrationRequest);

    // User Profile
    ResponseEntity<UserDto> getUserProfile(String username);

    // Update Profile
    ResponseEntity<UserDto> updateUserProfile(UpdateRequest updateRequest);

    // Password Reset
    ResponseEntity<String> resetPassword(UpdateRequest resetRequest);

}
