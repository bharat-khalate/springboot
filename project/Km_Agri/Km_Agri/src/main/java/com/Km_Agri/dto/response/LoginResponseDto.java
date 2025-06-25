package com.Km_Agri.dto.response;

import com.Km_Agri.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String token;
    private User user;
}
