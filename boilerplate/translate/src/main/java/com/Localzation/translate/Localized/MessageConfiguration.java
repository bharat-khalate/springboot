package com.Localzation.translate.Localized;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


@Configuration
public class MessageConfiguration {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource rs=new ResourceBundleMessageSource();
        System.out.println("hii");
        rs.setBasename("messages");
        rs.setDefaultEncoding("UTF-8");
        return rs;
    }
}
