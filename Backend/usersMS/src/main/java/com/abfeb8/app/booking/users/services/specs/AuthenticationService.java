package com.abfeb8.app.booking.users.services.specs;

import com.abfeb8.app.booking.users.dto.AuthenticationResponse;
import com.abfeb8.app.booking.users.dto.LoginRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UserDto;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest loginRequest);

    UserDto signup(RegistrationRequest registrationRequest);

    AuthenticationResponse logout(String jwt);
}
