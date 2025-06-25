package com.Km_Agri.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpertEntity {

    @JsonIgnore
    private int id;
    private int cropId;
    private double experience;
    private double ratings;
    private int pendingReq;

}
