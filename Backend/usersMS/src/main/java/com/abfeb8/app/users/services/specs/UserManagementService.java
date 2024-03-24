package com.abfeb8.app.users.services.specs;

import com.abfeb8.app.users.dto.PasswordResetRequest;
import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UpdateRequest;
import com.abfeb8.app.users.dto.UserDto;

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
    UserDto registerUser(RegistrationRequest registrationRequest);

    /**
     * retrieve user's information.
     *
     * @param username username for the corresponding user.
     * @return UserDTO.
     */
    UserDto getUser(String username);

    /**
     * update user's information.
     *
     * @param userId        ID of user.
     * @param updateRequest request containing updated user information.
     * @return updated user profile.
     */
    UserDto updateUserProfile(String userId, UpdateRequest updateRequest);

    /**
     * reset user password.
     *
     * @param resetRequest request containing user's email, new and old password.
     * @return A response indicating the success or failure of the password reset request.
     */
    String resetPassword(PasswordResetRequest resetRequest);

}



