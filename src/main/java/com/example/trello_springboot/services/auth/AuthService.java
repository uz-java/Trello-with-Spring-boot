package com.example.trello_springboot.services.auth;

import com.example.trello_springboot.config.security.SecurityUserDetails;
import com.example.trello_springboot.domains.auth.AuthUser;
import com.example.trello_springboot.dtos.auth.request.AccessTokenRequest;
import com.example.trello_springboot.dtos.auth.request.RefreshTokenRequest;
import com.example.trello_springboot.dtos.auth.response.TokenResponse;
import com.example.trello_springboot.repositories.AuthUserRepository;
import com.example.trello_springboot.services.base.BaseService;
import com.example.trello_springboot.services.jwt.AccessTokenService;
import com.example.trello_springboot.services.jwt.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:13 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService, BaseService {
    private final AuthUserRepository authUserRepository;
    private final AccessTokenService accessTokenService;
    private final RefreshTokenService refreshTokenService;

    @Override
    public SecurityUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> exception=()->{
            throw new UsernameNotFoundException("User not found");
        };
        AuthUser authUser=authUserRepository.findByUsername(username).orElseThrow(exception);
        return new SecurityUserDetails(authUser);
    }

    public TokenResponse generateToken(AccessTokenRequest request) {
        SecurityUserDetails userDetails = loadUserByUsername(request.username());
        String accessToken = accessTokenService.generateToken(userDetails);
        String refreshToken = refreshTokenService.generateToken(userDetails);
        return new TokenResponse(accessToken, refreshToken, userDetails.getUsername());
    }

    public TokenResponse refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.refreshToken();
        if (!refreshTokenService.isValid(refreshToken)){
            // TODO: 11/09/22 change the Exception class
            throw new RuntimeException("Token is invalid");
        }
        String username=refreshTokenService.getSubject(refreshToken);
        SecurityUserDetails userDetails=loadUserByUsername(username);
        String accessToken = accessTokenService.generateToken(userDetails);
        return  new TokenResponse(accessToken,refreshToken,username);
    }
}
