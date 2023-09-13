package com.abfeb8.app.booking.users.services;

import com.abfeb8.app.booking.users.dto.*;
import com.abfeb8.app.booking.users.entity.UserEntity;
import com.abfeb8.app.booking.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private final RoleService roleService;

    /**
     * Register a new user.
     *
     * @param registrationRequest The request containing user registration details.
     * @return A response indicating the success or failure of the registration.
     */
    @Override
    public ResponseEntity<String> registerUser(UserRegistrationRequest registrationRequest) {
        var newUser = UserEntity.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .email(registrationRequest.email())
                .password(registrationRequest.password())
                .username(registrationRequest.username())
                .build();

        newUser.setRoles(Set.of(roleService.getUserRole()));

        var savedUser = userRepository.save(newUser);
        return ResponseEntity.ok(String.format("User create with id: %d", savedUser.getId()));
    }

    /**
     * Authenticate a user based on login credentials.
     *
     * @param loginRequest The request containing user login credentials.
     * @return An authentication response containing an authentication token and user ID.
     */
    @Override
    public ResponseEntity<UserAuthenticationResponse> loginUser(UserLoginRequest loginRequest) {
        return null;
    }

    /**
     * Retrieve the user's profile information.
     *
     * @param userId The ID of the user to retrieve the profile for.
     * @return The user's profile information.
     */
    @Override
    public ResponseEntity<UserProfile> getUserProfile(Long userId) {
        return null;
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

    /**
     * Logout the user by invalidating the authentication token.
     *
     * @param authToken The authentication token to be invalidated.
     * @return A response indicating the success or failure of the logout operation.
     */
    @Override
    public ResponseEntity<String> logoutUser(String authToken) {
        return null;
    }
}
