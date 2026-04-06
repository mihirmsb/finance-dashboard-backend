package com.example.financial_backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/records/**").hasRole("ADMIN")
                        .requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "ANALYST")
                        .requestMatchers("/users/**").permitAll()

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService users(PasswordEncoder encoder) {

        UserDetails admin = User.builder()
                .username("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build();

        UserDetails analyst = User.builder()
                .username("analyst")
                .password(encoder.encode("analyst123"))
                .roles("ANALYST")
                .build();

        UserDetails viewer = User.builder()
                .username("viewer")
                .password(encoder.encode("viewer123"))
                .roles("VIEWER")
                .build();

        return new InMemoryUserDetailsManager(admin, analyst, viewer);
    }
}