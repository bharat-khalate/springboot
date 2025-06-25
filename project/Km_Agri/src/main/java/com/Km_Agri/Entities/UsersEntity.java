package com.Km_Agri.Entities;


import com.Km_Agri.Utils.StringConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UsersEntity {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id;

    @NotNull(message= StringConstants.nullPhoneNumberMessage)
    @Digits(integer=12,fraction = 0,message = StringConstants.invalidPhoneNumberMessage)
    private String phoneNumber;
    private String profilePicture;
    private Boolean status;
    private LocalDateTime lastSeen;
}
