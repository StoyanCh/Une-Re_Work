package com.example.uniservernew.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // вместо .csrf().disable()
                .csrf(AbstractHttpConfigurer::disable)

                // разрешаваме всички заявка само за аутентифицирани потребители
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                )

                // вместо .httpBasic()
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}