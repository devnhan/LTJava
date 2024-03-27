package com.example.lkmt.entity;


import com.example.lkmt.validator.annotation.ValidRoleId;
import com.example.lkmt.validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username must be less than 50 characters")
    @ValidUsername
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    @NotBlank(message = "Password is required")
    private String password;

    private String confirmpassword;

    @Column(name = "email", length = 50, nullable = false)
    @Size(max = 50, message =  "Email must be less than 50 characters")
    private String email;

    @Column(name = "fullname", length = 50, nullable = false)
    @Size(max = 50, message = "Your fullname must be less than characters")
    private String fullname;

    @Column(name = "address", length = 150, nullable = false)
    @Size(max = 150, message = "Your emaill must be less than 150 characters")
    private String address;

    @Column(name = "phone", length = 20, nullable = false)
    @Size(max = 20, message = "Phone must be less than 20 characters")
    private String phone;

    @ManyToMany
    @JoinTable(name= "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "role_id")
    @ValidRoleId
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;
}
