package com.pizza_palace_jpa.entities;

import com.pizza_palace_jpa.utils.PizzaSize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderLineId;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;
    @Enumerated(EnumType.STRING)
    private PizzaSize size;
    private Integer quantity;
    private Integer totlePrice;
}
