package com.abfeb8.app.users.services.impl;

import com.abfeb8.app.users.dto.AuthenticationResponse;
import com.abfeb8.app.users.dto.LoginRequest;
import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UserDto;
import com.abfeb8.app.users.services.specs.AuthenticationService;
import com.abfeb8.app.users.services.specs.JwtService;
import com.abfeb8.app.users.services.specs.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserManagementService userManagementService;


    @Override
    public AuthenticationResponse login(LoginRequest loginRequest) {
        var authenticationResponse = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );

        var userDetails = (UserDetails) authenticationResponse.getPrincipal();

        return AuthenticationResponse.builder()
                .username(userDetails.getUsername())
                .authToken(jwtService.generateToken(userDetails))
                .build();
    }

    @Override
    public UserDto signup(RegistrationRequest registrationRequest) {
        return userManagementService.registerUser(registrationRequest);
    }

    @Override
    public AuthenticationResponse logout(String jwt) {
        return null;
    }

}
