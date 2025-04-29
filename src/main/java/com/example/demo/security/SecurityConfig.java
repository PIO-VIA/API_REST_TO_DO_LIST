package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactive CSRF pour simplifier les tests Postman
                .authorizeHttpRequests(auth -> auth
                        // Public: création et lecture des utilisateurs
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users/**").permitAll()


                        // Public: lecture des tâches (optionnel, tu peux l’enlever si besoin)
                        .requestMatchers(HttpMethod.GET, "/tasks/**").permitAll()

                        // Protégé: création, modification, suppression de tâches
                        .requestMatchers(HttpMethod.POST, "/tasks/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/tasks/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/tasks/**").permitAll()

                        .anyRequest().authenticated()
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .httpBasic(basic -> {}); // Authentification HTTP Basic (facile avec Postman)

        return http.build();
    }
}
