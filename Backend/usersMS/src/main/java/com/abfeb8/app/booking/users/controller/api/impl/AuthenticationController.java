package com.abfeb8.app.booking.users.controller.api.impl;

import com.abfeb8.app.booking.users.controller.api.specs.AuthenticationApi;
import com.abfeb8.app.booking.users.dto.AuthenticationResponse;
import com.abfeb8.app.booking.users.dto.LoginRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import com.abfeb8.app.booking.users.services.specs.AuthenticationService;
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
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/logout")
    @Override
    public ResponseEntity<AuthenticationResponse> logout(@RequestBody String authToken) {
        return authenticationService.logout(authToken);
    }

    @PostMapping("/signup")
    @Override
    public ResponseEntity<UserDto> signup(@RequestBody RegistrationRequest registrationRequest) {
        return authenticationService.signup(registrationRequest);
    }
}
