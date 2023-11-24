package com.abfeb8.app.booking.users.repository;

import com.abfeb8.app.booking.users.entity.RoleEntity;
import com.abfeb8.app.booking.users.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByName(UserRole name);
}

