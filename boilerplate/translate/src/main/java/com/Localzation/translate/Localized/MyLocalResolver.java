package com.Localzation.translate.Localized;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class MyLocalResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language=request.getHeader("Accept-Language");
        if(language==null || language.isEmpty()){
            return Locale.forLanguageTag("en");
        }
        Locale l=Locale.forLanguageTag(language);
        if(LanguageConfig.languages.contains(l)){
            return l;
        }
        return Locale.forLanguageTag("en");
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
