package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.*;
import com.abfeb8.app.booking.users.services.UserServiceInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/user")
public class UserManagementManagementController implements UserManagementApiI {

    private final UserServiceInterface userService;

    @PostMapping("/create")
    @Override
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<UserAuthenticationResponse> loginUser(@RequestBody UserLoginRequest loginRequest) {
        return null;
    }

    @GetMapping("/profile/{userId}")
    @Override
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long userId) {
        return null;
    }

    @PostMapping("/profile/update/{userId}")
    @Override
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable Long userId, @RequestBody UserProfileUpdateRequest updateRequest) {
        return null;
    }

    @PostMapping("/password/reset")
    @Override
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest resetRequest) {
        return null;
    }

    @PostMapping("/logout")
    @Override
    public ResponseEntity<String> logoutUser(String authToken) {
        return null;
    }
}
