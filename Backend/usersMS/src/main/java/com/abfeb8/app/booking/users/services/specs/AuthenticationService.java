package com.abfeb8.app.booking.users.services.specs;

import com.abfeb8.app.booking.users.dto.AuthenticationResponse;
import com.abfeb8.app.booking.users.dto.LoginRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);
    ResponseEntity<UserDto> signup(RegistrationRequest registrationRequest);
    ResponseEntity<AuthenticationResponse> logout(String jwt);
}
