package com.abfeb8.app.booking.users.entity;

import com.abfeb8.app.booking.users.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 124540L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private UserRole name;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    @Override
    public String toString() {
        return String.format("[id: %d, role: \"%s\"]", this.getId(), this.getName());
    }

    public SimpleGrantedAuthority getGrantedAuthority() {
        return new SimpleGrantedAuthority(this.name.toString());
    }
}

