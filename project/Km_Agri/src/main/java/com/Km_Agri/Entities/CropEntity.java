package com.Km_Agri.Entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CropEntity {

    private int cropId;
    @NotNull(message = "Crop Name Can't Be Null")
    @NotEmpty(message = "Crop Name can't Be Empty")
    private String name;
}
