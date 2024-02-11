package com.abfeb8.app.booking.users.controller.api.impl;

import com.abfeb8.app.booking.users.controller.api.specs.UserManagementApi;
import com.abfeb8.app.booking.users.dto.PasswordResetRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UpdateRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import com.abfeb8.app.booking.users.services.specs.UserManagementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserManagementController implements UserManagementApi {

    private final UserManagementService userService;

    @PostMapping("create")
    @Override
    public ResponseEntity<UserDto> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        return userService.registerUser(registrationRequest);
    }

    @GetMapping("profile/{username}")
    @Override
    public ResponseEntity<UserDto> getUserProfile(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping("profile/update/{username}")
    @Override
    public ResponseEntity<UserDto> updateUserProfile(@PathVariable String username, @RequestBody UpdateRequest updateRequest) {
        return null;
    }

    @PostMapping("password/reset")
    @Override
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest resetRequest) {
        return null;
    }

}
