package com.example.trello_springboot.services.jwt;

import com.example.trello_springboot.config.security.SecurityUserDetails;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:32 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface TokenService {
    String generateToken(SecurityUserDetails userDetails);

    Boolean isValid(String token);
}
