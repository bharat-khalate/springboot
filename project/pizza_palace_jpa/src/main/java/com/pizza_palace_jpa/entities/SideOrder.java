package com.pizza_palace_jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sides_order")
public class SideOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sidesOrderId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "side_id")
    private Side side;

    @ManyToOne
    @JoinColumn(name = "order_line_id")
    private OrderLine orderLine;

    private Integer quantity;
}