package com.abfeb8.app.booking.users.services;

import com.abfeb8.app.booking.users.dto.UserAuthenticationResponse;
import com.abfeb8.app.booking.users.dto.UserDetailsDTO;
import com.abfeb8.app.booking.users.dto.UserLoginRequest;
import com.abfeb8.app.booking.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    /**
     * Authenticate a user based on login credentials.
     *
     * @param loginRequest The request containing user login credentials.
     * @return An authentication response containing an authentication token and user ID.
     */
    public ResponseEntity<UserAuthenticationResponse> loginUser(UserLoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
        );
        var user = userRepository.findByUsername(loginRequest.username())
                .orElseThrow((() -> new UsernameNotFoundException("No user found with username: " + loginRequest.username())));

        var authResponse = UserAuthenticationResponse.builder()
                .userId(user.getId())
                .authToken(jwtService.generateToken(UserDetailsDTO.convertToDto(user)))
                .build();

        return ResponseEntity.ok(authResponse);
    }

}
