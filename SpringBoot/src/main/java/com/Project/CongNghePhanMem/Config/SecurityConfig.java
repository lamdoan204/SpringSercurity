package com.Project.CongNghePhanMem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean

    public UserDetailsService UserDeatailService(PasswordEncoder encoder){
        UserDetails admin = User.withUsername("lam")
        .password(encoder.encode("123"))
        .roles("ADMIN")
        .build();
        UserDetails user = User.withUsername("user")
        .password(encoder.encode("123"))
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(admin, user);  
    }
    @Bean
    PasswordEncoder  passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
