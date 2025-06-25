package com.Km_Agri.dto;

import com.Km_Agri.entities.Auth;
import com.Km_Agri.entities.Expert;
import com.Km_Agri.entities.Room;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDto {

    private Long id;


    private String phoneNo;


    private String profilePicture;


    private Boolean status;


    private LocalDateTime lastSeen = LocalDateTime.now();


    private Long auth;


    private Long expert;


    private List<Long> roomList;


}
