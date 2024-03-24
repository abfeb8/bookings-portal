package com.abfeb8.app.users.controller.api.impl;

import com.abfeb8.app.users.controller.api.specs.AuthenticationApi;
import com.abfeb8.app.users.dto.AuthenticationResponse;
import com.abfeb8.app.users.dto.LoginRequest;
import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UserDto;
import com.abfeb8.app.users.services.specs.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @Override
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(
                authenticationService.login(loginRequest)
        );
    }

    @PostMapping("/logout")
    @Override
    public ResponseEntity<AuthenticationResponse> logout(@RequestBody String authToken) {
        return ResponseEntity.ok(
                authenticationService.logout(authToken)
        );
    }

    @PostMapping("/signup")
    @Override
    public ResponseEntity<UserDto> signup(@RequestBody RegistrationRequest registrationRequest) {
        return ResponseEntity.ok(
                authenticationService.signup(registrationRequest)
        );
    }
}
