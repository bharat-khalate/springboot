package com.Km_Agri.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // Auth endpoints
                        .requestMatchers("/auth/register/expert").hasRole("ADMIN")
                        .requestMatchers("/auth/**").permitAll()

                        // File access
                        .requestMatchers("/files/**").hasAnyRole("USER", "ADMIN", "EXPERT")

                        // Crop endpoints
                        .requestMatchers(HttpMethod.POST, "/crop").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/crop", "/crop/**").hasAnyRole("USER", "ADMIN", "EXPERT")

                        // Expert endpoints
                        .requestMatchers(HttpMethod.POST, "/expert").hasRole("EXPERT")
                        .requestMatchers(HttpMethod.GET, "/expert", "/expert/**").hasAnyRole("EXPERT", "ADMIN", "USER")

                        // Message and room/chat-related
                        .requestMatchers("/message", "/message/**").hasAnyRole("USER", "ADMIN", "EXPERT")
                        .requestMatchers("/ws", "/ws/**").hasAnyRole("USER", "ADMIN", "EXPERT")
                        .requestMatchers("/room", "/room/**").hasAnyRole("USER", "ADMIN", "EXPERT")

                        // Fallback: everything else requires authentication
                        .anyRequest().authenticated()
                )

                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .headers(headers -> headers
                        .contentTypeOptions(HeadersConfigurer.ContentTypeOptionsConfig::disable));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
