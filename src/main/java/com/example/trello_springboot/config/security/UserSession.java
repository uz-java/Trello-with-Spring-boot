package com.example.trello_springboot.config.security;

import com.example.trello_springboot.domains.auth.AuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:30 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Component
public record UserSession(HttpServletRequest request) {

    public AuthUser getDBUser() {
        AuthUser user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof AuthUser) {
                user = (AuthUser) authentication.getPrincipal();
            }
        }
        return user;
    }

    public String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
