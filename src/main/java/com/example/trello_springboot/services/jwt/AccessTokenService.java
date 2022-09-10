package com.example.trello_springboot.services.jwt;

import com.example.trello_springboot.config.security.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:31 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Service
public class AccessTokenService extends AbstractTokenService implements TokenService{

    @Value("${jwt.access.token.secret}")
    private String accessTokenSecret;

    @Value("${jwt.access.token.expiry.adding.amount}")
    private Integer amountToAdd;

    @Value("${jwt.access.token.expiry.time.unit}")
    private String unit;


    @Override
    public String generateToken(SecurityUserDetails userDetails) {
        return null;
    }

    @Override
    public Boolean isValid(String token) {
        return null;
    }
}
