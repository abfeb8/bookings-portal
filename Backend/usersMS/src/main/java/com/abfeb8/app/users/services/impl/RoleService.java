package com.abfeb8.app.users.services.impl;

import com.abfeb8.app.users.entity.RoleEntity;
import com.abfeb8.app.users.enums.UserRole;
import com.abfeb8.app.users.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @PostConstruct
    void init() {
        RoleEntity userRole = new RoleEntity();
        userRole.setName(UserRole.ROLE_USER);
        roleRepository.save(userRole);

        RoleEntity admin = new RoleEntity();
        admin.setName(UserRole.ROLE_ADMIN);
        roleRepository.save(admin);
    }

    public RoleEntity getUserRole() {
        return roleRepository.findByName(UserRole.ROLE_USER);
    }

    public RoleEntity getAdminRole() {
        return roleRepository.findByName(UserRole.ROLE_ADMIN);
    }
}
