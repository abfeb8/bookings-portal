package com.abfeb8.app.booking.users.services.impl;

import com.abfeb8.app.booking.users.dto.AuthenticationResponse;
import com.abfeb8.app.booking.users.dto.LoginRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import com.abfeb8.app.booking.users.services.specs.AuthenticationService;
import com.abfeb8.app.booking.users.services.specs.JwtService;
import com.abfeb8.app.booking.users.services.specs.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final UserManagementService userManagementService;


    @Override
    public ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );

        var userDetails = userDetailsService.loadUserByUsername(loginRequest.username());

        var authResponse = AuthenticationResponse.builder()
                .username(userDetails.getUsername())
                .authToken(jwtService.generateToken(userDetails))
                .build();

        return ResponseEntity.ok(authResponse);
    }

    @Override
    public ResponseEntity<UserDto> signup(RegistrationRequest registrationRequest) {
        return userManagementService.registerUser(registrationRequest);
    }

    @Override
    public ResponseEntity<AuthenticationResponse> logout(String jwt) {
        return null;
    }

}
