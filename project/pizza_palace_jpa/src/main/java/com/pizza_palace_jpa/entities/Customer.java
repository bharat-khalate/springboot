package com.pizza_palace_jpa.entities;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @JoinColumn(name = "email_address",nullable = false,unique = true)
    @OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER )
    private Users users;
}
