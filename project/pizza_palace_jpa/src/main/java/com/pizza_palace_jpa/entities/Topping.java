package com.pizza_palace_jpa.entities;

import com.pizza_palace_jpa.utils.PizzaType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "toppings")
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer toppingID;
    @Column(nullable = false)
    private Integer name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PizzaType type;
    @Column(nullable = false)
    private Integer toppingPrice;
    @Column(columnDefinition = "boolean default true")
    private boolean available;

    @OneToMany(mappedBy = "topping")
    private List<ToppingOrder> toppingOrderList;
}
