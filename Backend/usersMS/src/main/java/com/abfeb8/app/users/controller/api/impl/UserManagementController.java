package com.abfeb8.app.users.controller.api.impl;

import com.abfeb8.app.users.controller.api.specs.UserManagementApi;
import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UpdateRequest;
import com.abfeb8.app.users.dto.UserDto;
import com.abfeb8.app.users.services.specs.UserManagementService;
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
        return ResponseEntity.ok(userService.registerUser(registrationRequest));
    }

    @GetMapping("profile/{username}")
    @Override
    public ResponseEntity<UserDto> getUserProfile(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

    @PostMapping("profile/update")
    @Override
    public ResponseEntity<UserDto> updateUserProfile(@RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.ok(userService.updateUserProfile(updateRequest));
    }

    @PostMapping("password/reset")
    @Override
    public ResponseEntity<String> resetPassword(@RequestBody UpdateRequest resetRequest) {
        return ResponseEntity.ok(userService.resetPassword(resetRequest));
    }

}
