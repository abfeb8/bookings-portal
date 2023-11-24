package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.UserAuthenticationResponse;
import com.abfeb8.app.booking.users.dto.UserLoginRequest;
import com.abfeb8.app.booking.users.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
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
