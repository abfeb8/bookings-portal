package com.abfeb8.app.booking.users.dto;

import com.abfeb8.app.booking.users.entity.RoleEntity;
import com.abfeb8.app.booking.users.entity.UserEntity;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
public record UserDetailsDTO(String username, String password,
                             Collection<? extends GrantedAuthority> authorities) implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities();
    }

    @Override
    public String getPassword() {
        return this.password();
    }

    @Override
    public String getUsername() {
        return this.username();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetailsDTO convertToDto(UserEntity userEntity) {
        return UserDetailsDTO.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream()
                        .map(RoleEntity::getName)
                        .map(userRole -> new SimpleGrantedAuthority(userRole.toString()))
                        .toList())
                .build();
    }
}
