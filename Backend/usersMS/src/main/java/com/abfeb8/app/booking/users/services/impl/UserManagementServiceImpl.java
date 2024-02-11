package com.abfeb8.app.booking.users.services.impl;

import com.abfeb8.app.booking.users.dto.PasswordResetRequest;
import com.abfeb8.app.booking.users.dto.RegistrationRequest;
import com.abfeb8.app.booking.users.dto.UpdateRequest;
import com.abfeb8.app.booking.users.dto.UserDto;
import com.abfeb8.app.booking.users.entity.UserEntity;
import com.abfeb8.app.booking.users.repository.UserRepository;
import com.abfeb8.app.booking.users.services.specs.JwtService;
import com.abfeb8.app.booking.users.services.specs.UserManagementService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostConstruct
    void init() {
        UserEntity user = UserEntity.builder()
                .firstName("Abhishek")
                .lastName("Malviya")
                .username("abfeb8")
                .email("abfeb8@gmail.com")
                .phoneNumber("9589747474")
                .address("Abhishek Auto Parts")
                .password(bCryptPasswordEncoder.encode("1234"))
                .roles(Set.of(roleService.getUserRole()))
                .build();

        userRepository.save(user);
    }

    @Override
    public ResponseEntity<UserDto> registerUser(RegistrationRequest registrationRequest) {
        var newUser = createUserEntity(registrationRequest);

        var savedUser = userRepository.save(newUser);

        return ResponseEntity.ok(UserDto.convertToUserProfile(savedUser));
    }

    @Override
    public ResponseEntity<UserDto> getUser(String username) {
        var userEntity = getUserByUserName(username);

        return ResponseEntity.ok(UserDto.convertToUserProfile(userEntity));
    }

    @Override
    public ResponseEntity<UserDto> updateUserProfile(Long userId, UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<String> resetPassword(PasswordResetRequest resetRequest) {
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
                .email(registrationRequest.email())
                .password(bCryptPasswordEncoder.encode(registrationRequest.password()))
                .username(registrationRequest.username())
                .roles(Set.of(roleService.getUserRole()))
                .build();
    }
}
