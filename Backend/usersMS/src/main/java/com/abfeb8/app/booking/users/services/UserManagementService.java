package com.abfeb8.app.booking.users.services;

import com.abfeb8.app.booking.users.dto.*;
import com.abfeb8.app.booking.users.entity.UserEntity;
import com.abfeb8.app.booking.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserManagementService implements UserManagementServiceInterface, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Register a new user.
     *
     * @param registrationRequest The request containing user registration details.
     * @return A response indicating the success or failure of the registration.
     */
    @Override
    public ResponseEntity<UserAuthenticationResponse> registerUser(UserRegistrationRequest registrationRequest) {
        var newUser = createUserEntity(registrationRequest);

        var savedUser = userRepository.save(newUser);

        var authenticationResponse = UserAuthenticationResponse.builder()
                .username(savedUser.getUsername())
                .authToken(jwtService.generateToken(UserDetailsDTO.convertToDto(savedUser)))
                .build();

        return ResponseEntity.ok(authenticationResponse);
    }

    private UserEntity createUserEntity(UserRegistrationRequest registrationRequest) {
        return UserEntity.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .password(bCryptPasswordEncoder.encode(registrationRequest.password()))
                .username(registrationRequest.username())
                .roles(Set.of(roleService.getUserRole()))
                .build();
    }

    /**
     * Retrieve the user's profile information.
     *
     * @param username The username of the user to retrieve the profile for.
     * @return The user's profile information.
     */
    @Override
    public ResponseEntity<UserProfile> getUserProfile(String username) {
        var userEntity = getUserByUserName(username);

        return ResponseEntity.ok(UserProfile.convertToUserProfile(userEntity));
    }

    /**
     * Update the user's profile information.
     *
     * @param userId        The ID of the user to update the profile for.
     * @param updateRequest The request containing updated user profile information.
     * @return The updated user profile.
     */
    @Override
    public ResponseEntity<UserProfile> updateUserProfile(Long userId, UserProfileUpdateRequest updateRequest) {
        return null;
    }

    /**
     * Reset the user's password.
     *
     * @param resetRequest The request containing the user's email for password reset.
     * @return A response indicating the success or failure of the password reset request.
     */
    @Override
    public ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = getUserByUserName(username);

        return UserDetailsDTO.convertToDto(user);
    }

    private UserEntity getUserByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow((() -> new UsernameNotFoundException("No user with username: " + username)));
    }
}
