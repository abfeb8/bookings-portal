package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.UserAuthenticationResponse;
import com.abfeb8.app.booking.users.dto.UserLoginRequest;
import com.abfeb8.app.booking.users.services.AuthenticationService;
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
    public ResponseEntity<UserAuthenticationResponse> loginUser(@RequestBody UserLoginRequest loginRequest) {
        return authenticationService.loginUser(loginRequest);
    }

    @PostMapping("/logout")
    @Override
    public ResponseEntity<String> logoutUser(String authToken) {
        return null;
    }
}
