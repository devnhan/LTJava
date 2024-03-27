
package com.example.lkmt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long OrderId;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username is required")
    @Size(max = 50, message = "Username must be less than 50 characters")
//    @ValidUsername
    private String username;


    @Column(name = "email", length = 50, nullable = false)
    @Size(max = 50, message =  "Email must be less than 50 characters")
    private String email;

    @Column(name = "fullname", length = 50, nullable = false)
    @Size(max = 50, message = "Your fullname must be less than characters")
    private String fullname;

    @Column(name = "phonenumber", length = 20, nullable = true)
    @Size(max = 20, message = "Phone must be less than 20 characters")
    private String phonenumber;



    @ManyToMany
    @JoinTable(name = "order_detail",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}