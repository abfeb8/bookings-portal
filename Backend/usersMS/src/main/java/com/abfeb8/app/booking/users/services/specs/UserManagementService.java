package com.abfeb8.app.booking.users.services.specs;

import com.abfeb8.app.booking.users.dto.PasswordResetRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UpdateRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

/**
 * Service interface for Users CRUD operations.
 */
public interface UserManagementService {

    /**
     * register a new user.
     *
     * @param registrationRequest request containing user registration details.
     * @return A response indicating the success or failure of the registration.
     */
    ResponseEntity<UserDto> registerUser(RegistrationRequest registrationRequest);

    /**
     * retrieve user's information.
     *
     * @param username username for the corresponding user.
     * @return UserDTO.
     */
    ResponseEntity<UserDto> getUser(String username);

    /**
     * update user's information.
     *
     * @param userId        ID of user.
     * @param updateRequest request containing updated user information.
     * @return updated user profile.
     */
    ResponseEntity<UserDto> updateUserProfile(Long userId, UpdateRequest updateRequest);

    /**
     * reset user password.
     *
     * @param resetRequest request containing user's email, new and old password.
     * @return A response indicating the success or failure of the password reset request.
     */
    ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest);

}



