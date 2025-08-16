package com.foroAluraLatam.demo.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())               // deshabilita CSRF
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // permite todo

        return http.build();
    }
}