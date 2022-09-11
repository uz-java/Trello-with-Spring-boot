package com.example.trello_springboot.services.jwt;

import com.example.trello_springboot.config.security.SecurityUserDetails;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:32 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Service
public class RefreshTokenService extends AbstractTokenService implements TokenService {

    @Value("${jwt.refresh.token.secret}")
    private String refreshTokenSecret;

    @Value("${jwt.refresh.token.expiry.adding.amount}")
    private Integer amountToAdd;

    @Value("${jwt.refresh.token.expiry.time.unit}")
    private String unit;

    @Override
    public String generateToken(SecurityUserDetails userDetails) {
        return jwt(userDetails.getUsername());
    }

    @Override
    public Boolean isValid(String token) {
        return super.isTokenValid(token, refreshTokenSecret);
    }

    public String getSubject(String token) {
        return super.getSubject(token, refreshTokenSecret);
    }

    public String jwt(@NonNull String subject) {
        return super.jwt(subject, this.refreshTokenSecret, this.amountToAdd, ChronoUnit.valueOf(this.unit));
    }
}
