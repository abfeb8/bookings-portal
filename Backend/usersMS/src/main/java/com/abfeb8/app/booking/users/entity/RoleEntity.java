package com.abfeb8.app.booking.users.entity;

import com.abfeb8.app.booking.users.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity {
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
}

