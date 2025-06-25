package com.Km_Agri.Dto.Requests;

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
public class RegisterExpertReqDto {
    @NotNull(message = "Phone Number Can't Be Null")
    @NotEmpty(message = "Phone Number Can't Be Empty")
    @Length(min=12, max = 12,message = "Please Enter 10 Digit Number")
    private String phoneNumber;

    @NotNull(message = "User Name Can't Be Null")
    @NotEmpty(message = "User Name Can't Be Empty")
    @Length(min=8, max = 20,message = "Please Enter Valid User Name")
    private String userName;

    @NotNull(message = "Password Can't Be Null")
    @NotEmpty(message = "Password Can't Be Empty")
    @Length(min=10, max = 56,message = "Please Enter password From 10 Digit To 56 Digit")
    private String password;
    private String roll;

    @Min(value = 1,message = "Id Must Be Positive")
    private int cropId;

    @Min(value = 0,message = "Experience Must Be Positive")
    private double experience;
    private double ratings;
    private int pendingReq;
}
