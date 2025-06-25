package com.Km_Agri.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "profile_picture")
    private String profilePicture;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "last_seen")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime lastSeen = LocalDateTime.now();

    @JsonBackReference(value = "user-auth")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "user")
    private Auth auth;

    @JsonIgnoreProperties({"user"})
    @OneToOne(cascade = {
            CascadeType.REMOVE, CascadeType.PERSIST
    }, mappedBy = "user")
    private Expert expert;

//    @OneToMany(mappedBy = "user")
//    private List<Group> group;

    //    @OneToMany(mappedBy = "fromUser")
//    private List<Message> messageSentList;
//
//    @OneToMany(mappedBy = "toUser")
//    private List<Message> messageRecievedList;
//
    @JsonIgnoreProperties("userList")
    @ManyToMany(mappedBy = "userList")
    private List<Room> roomList;

}
