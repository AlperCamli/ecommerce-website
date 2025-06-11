package com.nature.Nature.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")  // Renaming the table to "users" to avoid conflicts
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String userLastname;
    private String email;
    private String password;
    private String phoneNumber;
    private String city;
    private String address;
    private String expertise;

    @Enumerated(EnumType.STRING)
    private Role role;
}

enum Role {
    DOCTOR, ADMIN, SUBSIDIARY
}
