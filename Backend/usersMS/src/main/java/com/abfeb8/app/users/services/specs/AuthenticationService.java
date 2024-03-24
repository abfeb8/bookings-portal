package com.abfeb8.app.users.services.specs;

import com.abfeb8.app.users.dto.AuthenticationResponse;
import com.abfeb8.app.users.dto.LoginRequest;
import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UserDto;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest loginRequest);

    UserDto signup(RegistrationRequest registrationRequest);

    AuthenticationResponse logout(String jwt);
}
