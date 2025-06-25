package com.pizza_palace_jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CrustOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crustOrderId;


    @ManyToOne
    @JoinColumn(name = "crust_id")
    private Crust crust;

    @ManyToOne
    @JoinColumn(name = "order_line_id")
    private OrderLine orderLine;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
