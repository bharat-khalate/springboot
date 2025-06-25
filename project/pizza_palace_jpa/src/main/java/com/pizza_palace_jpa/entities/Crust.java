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
public class Crust {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crustId;

    private String crustName;

    @OneToMany(mappedBy = "crust")
    private List<CrustOrder> crustOrder;

}
