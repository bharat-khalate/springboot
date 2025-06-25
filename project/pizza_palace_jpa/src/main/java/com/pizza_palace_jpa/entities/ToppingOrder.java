package com.pizza_palace_jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "toppings_orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToppingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer toppingOrderId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "order_line_id")
    private OrderLine orderLine;
    @ManyToOne
    @JoinColumn(name = "topping_id")
    private Topping topping;

}
