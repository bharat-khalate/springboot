package com.Km_Agri.Service;

import com.Km_Agri.Dto.Requests.RegisterExpertReqDto;
import com.Km_Agri.Dto.Requests.RegisterUserReqDto;
import com.Km_Agri.Dto.Response.RegisterExpertResDto;
import com.Km_Agri.Dto.Response.RegisterUserResDto;
import com.Km_Agri.Entities.AuthEntity;
import com.Km_Agri.Entities.ExpertEntity;
import com.Km_Agri.Entities.UsersEntity;
import com.Km_Agri.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {
    @Autowired
    private UsersService usersService;
    @Autowired
    private  AuthService authService;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private ExpertService expertService;

    @Transactional
    public RegisterUserResDto createUsers(RegisterUserReqDto registerUserReqDto, MultipartFile file){
        RegisterUserResDto registerUserResDto =new RegisterUserResDto();
        String fileName=fileStorageService.uplaodFile(file);
        UsersEntity usersEntity=new UsersEntity();
        usersEntity.setPhoneNumber(registerUserReqDto.getPhoneNumber());
        usersEntity.setProfilePicture("http://localhost:8080/api/file/"+fileName);
        usersEntity=usersService.addUser(usersEntity);
        AuthEntity authEntity=new AuthEntity();
        authEntity.setUserName(registerUserReqDto.getUserName());
        authEntity.setPassword(passwordEncoder.encode(registerUserReqDto.getPassword()));
        authEntity.setId(usersEntity.getId());
        authEntity.setRoll(registerUserReqDto.getRoll());
        authService.addAuth(authEntity);
        registerUserResDto.setUsersEntity(usersEntity);
        String token=jwtUtils.generateToken(authEntity);
        registerUserResDto.setAuthorization("Bearer "+token);
        return registerUserResDto;
    }


    @Transactional
    public RegisterExpertResDto createExperts(RegisterExpertReqDto registerExpertReqDto, MultipartFile file){
        RegisterExpertResDto registerExpertResDto =new RegisterExpertResDto();
        AuthEntity authEntity=new AuthEntity();
        UsersEntity usersEntity=new UsersEntity();
        ExpertEntity expertEntity=new ExpertEntity();
        String fileName=fileStorageService.uplaodFile(file);
        usersEntity.setPhoneNumber(registerExpertReqDto.getPhoneNumber());
        usersEntity.setProfilePicture("http://localhost:8080/api/file/"+fileName);
        usersEntity=usersService.addUser(usersEntity);
        authEntity.setUserName(registerExpertReqDto.getUserName());
        authEntity.setPassword(passwordEncoder.encode(registerExpertReqDto.getPassword()));
        authEntity.setId(usersEntity.getId());
        authEntity.setRoll(registerExpertReqDto.getRoll());
        authService.addAuth(authEntity);
        expertEntity.setId(usersEntity.getId());
        expertEntity.setExperience(registerExpertReqDto.getExperience());
        expertEntity.setCropId(registerExpertReqDto.getCropId());
        expertEntity=expertService.addExpert(expertEntity);
        registerExpertResDto.setUsersEntity(usersEntity);
        registerExpertResDto.setExpertEntity(expertEntity);
        String token=jwtUtils.generateToken(authEntity);
        registerExpertResDto.setAuthorization("Bearer "+token);
        return registerExpertResDto;
    }


}
