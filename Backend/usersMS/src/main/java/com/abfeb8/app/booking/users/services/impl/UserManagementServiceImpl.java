package com.abfeb8.app.booking.users.services.impl;

import com.abfeb8.app.booking.users.dto.PasswordResetRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UpdateRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import com.abfeb8.app.booking.users.entity.ContactEntity;
import com.abfeb8.app.booking.users.entity.UserEntity;
import com.abfeb8.app.booking.users.repository.UserRepository;
import com.abfeb8.app.booking.users.services.specs.UserManagementService;
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
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

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
        var newUser = createUserEntity(registrationRequest);

        var savedUser = userRepository.save(newUser);

        return UserDto.convertToUserProfile(savedUser);
    }

    @Override
    public UserDto getUser(String username) {
        var userEntity = getUserByUserName(username);

        return UserDto.convertToUserProfile(userEntity);
    }

    @Override
    public UserDto updateUserProfile(Long userId, UpdateRequest updateRequest) {
        return null;
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
        return userRepository.findByUsername(username)
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
