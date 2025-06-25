package com.Km_Agri.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crop_id")
    private Long cropId;

    private String name;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "crop")
//    private Expert expert;
}
