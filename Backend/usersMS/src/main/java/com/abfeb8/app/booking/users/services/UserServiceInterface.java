package com.abfeb8.app.booking.users.services;

import com.abfeb8.app.booking.users.dto.*;
import org.springframework.http.ResponseEntity;

/**
 * Service interface for Authentication and User Management operations.
 */
public interface UserServiceInterface {

    /**
     * Register a new user.
     *
     * @param registrationRequest The request containing user registration details.
     * @return A response indicating the success or failure of the registration.
     */
    ResponseEntity<String> registerUser(UserRegistrationRequest registrationRequest);

    /**
     * Authenticate a user based on login credentials.
     *
     * @param loginRequest The request containing user login credentials.
     * @return An authentication response containing an authentication token and user ID.
     */
    ResponseEntity<UserAuthenticationResponse> loginUser(UserLoginRequest loginRequest);

    /**
     * Retrieve the user's profile information.
     *
     * @param userId The ID of the user to retrieve the profile for.
     * @return The user's profile information.
     */
    ResponseEntity<UserProfile> getUserProfile(Long userId);

    /**
     * Update the user's profile information.
     *
     * @param userId        The ID of the user to update the profile for.
     * @param updateRequest The request containing updated user profile information.
     * @return The updated user profile.
     */
    ResponseEntity<UserProfile> updateUserProfile(Long userId, UserProfileUpdateRequest updateRequest);

    /**
     * Reset the user's password.
     *
     * @param resetRequest The request containing the user's email for password reset.
     * @return A response indicating the success or failure of the password reset request.
     */
    ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest);

    /**
     * Logout the user by invalidating the authentication token.
     *
     * @param authToken The authentication token to be invalidated.
     * @return A response indicating the success or failure of the logout operation.
     */
    ResponseEntity<String> logoutUser(String authToken);
}



