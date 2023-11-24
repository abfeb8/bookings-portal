package com.abfeb8.app.booking.users.controller;

import com.abfeb8.app.booking.users.dto.UserAuthenticationResponse;
import com.abfeb8.app.booking.users.dto.UserLoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationApi {
    // User Login
    ResponseEntity<UserAuthenticationResponse> loginUser(UserLoginRequest loginRequest);

    // Logout
    ResponseEntity<String> logoutUser(String authToken);
}
