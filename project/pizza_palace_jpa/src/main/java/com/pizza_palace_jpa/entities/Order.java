package com.pizza_palace_jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Column(columnDefinition = "varchar(255) default 'CREATED'")
    private String status;
    private Integer totalAmount;
    private LocalDateTime orderDateTime;
    private String deliveryAddress;
    private boolean valid;
}
