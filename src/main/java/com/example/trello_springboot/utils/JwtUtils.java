package com.example.trello_springboot.utils;

import com.example.trello_springboot.services.jwt.AccessTokenService;
import com.example.trello_springboot.services.jwt.RefreshTokenService;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:36 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public class JwtUtils {
    public static final AccessTokenService accessTokenService = new AccessTokenService();
    public static final RefreshTokenService refreshTokenService = new RefreshTokenService();
}
