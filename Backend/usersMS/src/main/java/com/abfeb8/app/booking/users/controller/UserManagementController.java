package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.*;
import com.abfeb8.app.booking.users.services.UserManagementServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserManagementController implements UserManagementApi {

    private final UserManagementServiceInterface userService;

    @PostMapping("create")
    @Override
    public ResponseEntity<UserAuthenticationResponse> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @GetMapping("profile/{username}")
    @Override
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable String username) {
        return userService.getUserProfile(username);
    }

    @PostMapping("profile/update/{username}")
    @Override
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable String username, @RequestBody UserProfileUpdateRequest updateRequest) {
        return null;
    }

    @PostMapping("password/reset")
    @Override
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest resetRequest) {
        return null;
    }

}
