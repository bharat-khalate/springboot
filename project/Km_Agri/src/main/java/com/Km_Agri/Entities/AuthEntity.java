package com.Km_Agri.Entities;

import com.Km_Agri.Utils.StringConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthEntity {
    @NotNull(message= StringConstants.nullUserNameMessage)
    @NotEmpty(message = StringConstants.invalidUserNameMessage)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private int id;
    private String roll;
}
