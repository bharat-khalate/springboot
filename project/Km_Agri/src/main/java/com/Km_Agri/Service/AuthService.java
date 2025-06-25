package com.Km_Agri.Service;

import com.Km_Agri.Entities.AuthEntity;
import com.Km_Agri.Mapper.AuthMapper;
import com.Km_Agri.Utils.StringConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthService {

    @Autowired
    private AuthMapper authMapper;

    public AuthEntity addAuth(AuthEntity authEntity){
        authMapper.insertAuth(authEntity);
        return  authEntity;
    }

    public AuthEntity getAuth(AuthEntity authEntity){
        authEntity=authMapper.getAuth(authEntity);
        if(authEntity!=null) return authEntity;
        throw new NoSuchElementException("No users Found With the given credential");
    }

    public AuthEntity getAuthByUserName(String userName){
        AuthEntity authEntity=authMapper.getAuthByUserName(userName);
        if(authEntity!=null) return authEntity;
        throw new NoSuchElementException("No users Found With the given credential");
    }
}
