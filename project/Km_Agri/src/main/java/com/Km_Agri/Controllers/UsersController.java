package com.Km_Agri.Controllers;

import com.Km_Agri.Dto.Requests.RegisterUserReqDto;
import com.Km_Agri.Dto.Response.RegisterUserResDto;
import com.Km_Agri.Dto.SuccessResponseDto;
import com.Km_Agri.Entities.AuthEntity;
import com.Km_Agri.Entities.UsersEntity;
import com.Km_Agri.Service.AuthService;
import com.Km_Agri.Service.CommonService;
import com.Km_Agri.Service.UsersService;
import com.Km_Agri.Utils.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/auth")
public class UsersController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UsersService usersService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value="/",consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //Registration Process
    public ResponseEntity<?> addUser(@ModelAttribute RegisterUserReqDto registerUserReqDto,
                                     @RequestParam("file") MultipartFile file){
        registerUserReqDto.setRoll("USER");
        RegisterUserResDto registerUserResDto =commonService.createUsers(registerUserReqDto,file);
        SuccessResponseDto successResponseDto=new SuccessResponseDto(true,"User Created Successfully", List.of(registerUserResDto));
        return ResponseEntity.status(HttpStatus.OK).body(successResponseDto);
    }

    @GetMapping("/") //Login Process
    public ResponseEntity<?> getUser(@Valid @RequestBody AuthEntity authEntity){
        String password=authEntity.getPassword();
        authEntity=authService.getAuthByUserName(authEntity.getUserName());
        if(!passwordEncoder.matches(password,authEntity.getPassword()))
            throw new NoSuchElementException("Wrong Password");
        UsersEntity usersEntity=usersService.getUsersById(authEntity.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new RegisterUserResDto(usersEntity,"Bearer "+jwtUtils.generateToken(authEntity)));
    }


}
