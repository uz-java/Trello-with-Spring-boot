package com.example.trello_springboot.config.encoders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:29 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Configuration
public class Encoders {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
