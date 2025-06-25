package com.pizza_palace_jpa.entities;

import com.pizza_palace_jpa.utils.PizzaType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.List;

@Table(name = "pizzas")
@Entity
@Data
@NoArgsConstructor
@AllowNonPortable
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pizzaId;

    @Column(nullable = false)
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private PizzaType type;

    private String imageUrl;
    @Column(nullable = false)
    private Integer priceRegularSize;
    @Column(nullable = false)
    private Integer priceMediumSize;
    @Column(nullable = false)
    private Integer pricelargeSize;

    @OneToMany(mappedBy = "pizza")
    private List<OrderLine> orderLineList;
}
