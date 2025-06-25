package com.Km_Agri.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponseDto {
    private boolean success;
    private String message;
    private List<?> data;
}
