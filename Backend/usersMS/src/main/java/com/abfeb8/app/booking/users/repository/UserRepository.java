package com.abfeb8.app.booking.users.repository;

import com.abfeb8.app.booking.users.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(@NonNull String username);

    Optional<UserEntity> findByEmail(@NonNull String email);
}
