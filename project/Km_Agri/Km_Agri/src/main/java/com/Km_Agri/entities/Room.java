package com.Km_Agri.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "rooms")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "is_group")
    private Boolean isGroup;

    @Column(name = "initial_image")
    private String initialImage;

    @Column(name = "is_private", columnDefinition = "boolean default false")
    private Boolean isPrivate = false;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "room")
//    private Group group;

//    @OneToMany(mappedBy = "room")
//    private List<Message> messageList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "participant", joinColumns = {
            @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "participant_id", referencedColumnName = "id")
            })
    @JsonIgnoreProperties({"roomList"})
    private List<User> userList;
}
