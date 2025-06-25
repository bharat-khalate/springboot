package com.Km_Agri;

import com.Km_Agri.entities.Auth;
import com.Km_Agri.entities.User;
import com.Km_Agri.service.AuthService;
import com.Km_Agri.utils.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
public class KmAgriApplication implements CommandLineRunner {

    private final AuthService authService;
//    private final MessageService messageService;

    public static void main(String[] args) {
        SpringApplication.run(KmAgriApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\n*******************************Application Started*******************************\n");
        User user = new User(null, "8010269748", "http://localhost:9090/files/1749745594436", false, LocalDateTime.now(), null, null, null);
        Auth auth = new Auth(null, "bharat", user, "1234567890", Roles.ADMIN);
        authService.addAuth(auth);
    }
}
