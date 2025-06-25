package com.Km_Agri.Dto.Response;

import com.Km_Agri.Entities.UsersEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResDto {
    private UsersEntity usersEntity;
    String authorization;
}
