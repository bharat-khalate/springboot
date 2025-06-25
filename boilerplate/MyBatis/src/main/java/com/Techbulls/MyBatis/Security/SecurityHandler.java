package com.Techbulls.MyBatis.Security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class SecurityHandler {

    @Bean
    public UserDetailsManager userDetailsanager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager= new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "SELECT username, pwd, enabled FROM users WHERE username=?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT u.username, a.role FROM authorities a INNER JOIN users u ON a.userid = u.id WHERE u.username=?"
        );

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterhain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/viewAllEmployee").hasAuthority("ROLE_EMPLOYEE") // Change to .hasAuthority()
                        .requestMatchers(HttpMethod.GET, "/viewEmployeeById/**").hasAuthority("ROLE_EMPLOYEE")
                        .requestMatchers(HttpMethod.PUT, "/updateEmployee/**").hasAuthority("ROLE_MANAGER")
                        .requestMatchers(HttpMethod.POST, "/createEmployee").hasAuthority("ROLE_MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/deleteEmployeeById/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET, "/viewEmployeeByFirstName/**").hasAuthority("ROLE_EMPLOYEE")
                        .anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
}
