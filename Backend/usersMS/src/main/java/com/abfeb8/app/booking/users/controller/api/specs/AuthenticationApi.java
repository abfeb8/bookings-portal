package com.abfeb8.app.booking.users.controller.api.specs;

import com.abfeb8.app.booking.users.dto.AuthenticationResponse;
import com.abfeb8.app.booking.users.dto.LoginRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationApi {
    /**
     * Authenticate a user based on login credentials.
     *
     * @param loginRequest The request containing user login credentials.
     * @return An authentication response containing an authentication token and user ID.
     */
    ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);

    // Logout
    ResponseEntity<AuthenticationResponse> logout(String authToken);

    // Signup
    ResponseEntity<UserDto> signup(RegistrationRequest registrationRequest);
}
