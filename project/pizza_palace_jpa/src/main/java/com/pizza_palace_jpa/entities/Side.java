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
@Table(name = "sides")
public class Side {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sidesId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
    @Column(columnDefinition = "boolean default true")
    private boolean available;

    @OneToMany(mappedBy = "side")
    private List<SideOrder> sideOrder;

}
