package com.Localzation.translate.Controllers;

import com.Localzation.translate.Localized.MyLocalResolver;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Responder {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MyLocalResolver myLocalResolver;

    @GetMapping("/")
    public ResponseEntity<String> sendMSG(HttpServletRequest http){
        String msg=messageSource.getMessage("greeting",null,myLocalResolver.resolveLocale(http));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/plain; charset=UTF-8"))
                .body(msg);
    }
}
