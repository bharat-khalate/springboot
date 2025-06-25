package com.Km_Agri.controllers;

import com.Km_Agri.dto.ResponseStructure;
import com.Km_Agri.dto.requests.LoginRequestDto;
import com.Km_Agri.dto.response.LoginResponseDto;
import com.Km_Agri.entities.Auth;
import com.Km_Agri.service.AuthService;
import com.Km_Agri.service.FileService;
import com.Km_Agri.utils.JwtUtils;
import com.Km_Agri.utils.Roles;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class Autentication {
    private final AuthService authService;
    private final FileService fileService;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @PostMapping(path = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> creeateUser(@Valid @RequestPart("auth") String authString, @RequestPart("file") MultipartFile file) throws JsonProcessingException {
        Auth auth = new ObjectMapper().readValue(authString, Auth.class);
        auth.getUser().setProfilePicture(fileService.addFile(file));
        auth.setRole(Roles.USER);
        auth = authService.addAuth(auth);
        ResponseStructure responseStructure = new ResponseStructure(200, true, List.of(auth));
        return ResponseEntity.ok(responseStructure);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> getUsers(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        Auth auth = authService.getAuthByUserName(loginRequestDto.getUserName());
        if (!passwordEncoder.matches(loginRequestDto.getPassword(), auth.getPassword())) {
            throw new NoSuchElementException("Wrong password");
        }
        LoginResponseDto loginResponseDto = new LoginResponseDto(jwtUtils.generateToken(auth), auth.getUser());
        ResponseStructure responseStructure = new ResponseStructure(200, true, List.of(loginResponseDto));
        return ResponseEntity.ok(responseStructure);
    }

    @PostMapping(path = "/register/expert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createExpert(@RequestPart("auth") String authString, @RequestPart("file") MultipartFile file) throws JsonProcessingException {
        Auth auth = new ObjectMapper().readValue(authString, Auth.class);
        auth.getUser().setProfilePicture(fileService.addFile(file));
        auth.setRole(Roles.EXPERT);
        auth = authService.addAuth(auth);
        ResponseStructure responseStructure = new ResponseStructure(200, true, List.of(auth));
        return ResponseEntity.ok(responseStructure);
    }


}
