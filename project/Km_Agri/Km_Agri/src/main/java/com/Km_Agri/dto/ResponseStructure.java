package com.Km_Agri.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseStructure {
    int response;
    boolean success;
    List<?> data;
}
