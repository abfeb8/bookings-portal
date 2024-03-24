package com.abfeb8.app.users.services.impl;

import com.abfeb8.app.users.dto.PasswordResetRequest;
import com.abfeb8.app.users.dto.RegistrationRequest;
import com.abfeb8.app.users.dto.UpdateRequest;
import com.abfeb8.app.users.dto.UserDto;
import com.abfeb8.app.users.entity.ContactEntity;
import com.abfeb8.app.users.entity.UserEntity;
import com.abfeb8.app.users.repository.UserRepository;
import com.abfeb8.app.users.services.specs.UserManagementService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostConstruct
    void init() {
        UserEntity user = UserEntity.builder()
                .firstName("Abhishek")
                .lastName("Malviya")
                .username("abfeb8")
                .contact(ContactEntity.builder()
                        .email("abfeb8@gmail.com")
                        .phoneNumber("9589747474")
                        .address("Indore")
                        .build()
                )
                .password(bCryptPasswordEncoder.encode("1234"))
                .roles(Set.of(
                        roleService.getUserRole(),
                        roleService.getAdminRole()
                ))
                .build();

        userRepository.save(user);
    }

    @Override
    public UserDto registerUser(RegistrationRequest registrationRequest) {
        if (registrationRequest == null) {
            throw new RuntimeException("registration request can not be null");
        }

        return Optional.of(registrationRequest)
                .map(this::createUserEntity)
                .map(userRepository::save)
                .map(UserDto::convertToDto)
                .orElseThrow(() -> new RuntimeException("failed to register new user"));
    }

    @Override
    public UserDto getUser(String username) {
        if (username == null) {
            throw new RuntimeException("username can not be null");
        }

        return Optional.of(username)
                .map(this::getUserByUserName)
                .map(UserDto::convertToDto)
                .orElseThrow(() -> new RuntimeException(String.format("failed to fetch user %s", username)));
    }

    @Override
    public UserDto updateUserProfile(String userName, UpdateRequest updateRequest) {
        if (userName == null || updateRequest == null) {
            throw new RuntimeException("userName/updateRequest are required");
        }

        return Optional.of(userName)
                .map(this::getUserByUserName)
                .map(userEntity -> updateUserContact(userEntity, updateRequest))
                .map(userRepository::save)
                .map(UserDto::convertToDto)
                .orElseThrow(() -> new RuntimeException("error while updating user details"));
    }

    private UserEntity updateUserContact(
            @NonNull UserEntity userEntity,
            @NonNull UpdateRequest updateRequest) {

        var contact = userEntity.getContact();
        Optional.ofNullable(updateRequest.address())
                .ifPresent(contact::setAddress);

        Optional.ofNullable(updateRequest.phoneNumber())
                .ifPresent(contact::setPhoneNumber);

        return userEntity;
    }

    @Override
    public String resetPassword(PasswordResetRequest resetRequest) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(username)
                .map(this::getUserByUserName)
                .orElseThrow(() -> new RuntimeException("username can not be null"));
    }

    private UserEntity getUserByUserName(@NonNull String username) {
        return Optional.of(username)
                .flatMap(userRepository::findByUsername)
                .orElseThrow((() -> new RuntimeException("no user found for username: " + username)));
    }

    private UserEntity createUserEntity(RegistrationRequest registrationRequest) {
        return UserEntity.builder()
                .firstName(registrationRequest.firstName())
                .lastName(registrationRequest.lastName())
                .username(registrationRequest.username())
                .contact(ContactEntity.builder()
                        .email(registrationRequest.email())
                        .build()
                )
                .password(bCryptPasswordEncoder.encode(registrationRequest.password()))
                .roles(Set.of(roleService.getUserRole()))
                .build();
    }
}
