package com.Km_Agri.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Validated
public class LoginRequestDto {
    @NotNull(message = "user name cant be null")
    @NotEmpty(message = "user Name cant be empty")
    private String userName;
    @NotNull(message = "password cant be null")
    @NotEmpty(message = "password cant be empty")
    private String password;
}
