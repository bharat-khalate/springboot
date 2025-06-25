package com.Km_Agri.entities;

import com.Km_Agri.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import static jakarta.persistence.CascadeType.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "auth")
@Validated
@JsonIgnoreProperties(ignoreUnknown = true)
public class Auth {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "user name cant be empty")
    @NotEmpty(message = "user name cant be empty")
    @Column(name = "user_name", unique = true)
    private String userName;
    @NotNull(message = "user info cant be empty")
    @JsonManagedReference(value = "user-auth")
    @OneToOne(cascade = {PERSIST, REMOVE})
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    @NotNull(message = "password cant be empty")
    @NotEmpty(message = "password cant be empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;
    @NotNull(message = "Role cant be empty")
    @Enumerated(EnumType.STRING)
    private Roles role;
}
