package com.Km_Agri.Dto.Response;

import com.Km_Agri.Entities.ExpertEntity;
import com.Km_Agri.Entities.UsersEntity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterExpertResDto {
   private UsersEntity usersEntity;
   private ExpertEntity expertEntity;
   private String authorization;
}
