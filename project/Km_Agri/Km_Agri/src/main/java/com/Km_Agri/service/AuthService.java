package com.Km_Agri.service;

import com.Km_Agri.entities.Auth;
import com.Km_Agri.entities.Expert;
import com.Km_Agri.entities.User;
import com.Km_Agri.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Auth addAuth(Auth auth) {
        auth.setPassword(passwordEncoder.encode(auth.getPassword()));
        User user = auth.getUser();
        auth.setUser(user);
        if (user.getExpert() != null) {
            Expert expert = user.getExpert();
            expert.setUser(user);
        }
        return authRepository.save(auth);
    }

    @Transactional
    public List<Auth> getAllAuth() {
        List<Auth> authList = new ArrayList<>();
        authRepository.findAll().forEach(authList::add);
        return authList;
    }

    @Transactional
    public Auth getAuthByUserName(String userName) {
        return authRepository.findByUserName(userName).orElseThrow(() -> new NoSuchElementException("No such user Exists"));
    }

    @Transactional
    public Auth updateAuthByUserName(String userName, Auth auth) {
        auth.setUserName(userName);
        return authRepository.save(auth);
    }

    public boolean deleteAuthByUserName(String userName) {
        this.getAuthByUserName(userName);
        authRepository.deleteByUserName(userName);
        return true;
    }


}
