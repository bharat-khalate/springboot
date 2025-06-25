package com.Km_Agri.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Remove;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "experts")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //    @JsonIgnoreProperties({"expert","auth"})
    @OneToOne(cascade = {PERSIST, REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", unique = true)
    private Crop crop;


    @Column(nullable = false)
    private Double experience;
    private Double ratings;
    @Column(name = "pending_requests", columnDefinition = "int default 0")
    private Integer pendingRequests = 0;

}
