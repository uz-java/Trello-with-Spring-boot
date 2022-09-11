package com.example.trello_springboot.config.security.jwt;

import com.example.trello_springboot.services.auth.AuthService;
import com.example.trello_springboot.services.jwt.AccessTokenService;
import com.example.trello_springboot.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:42 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final AuthService authService;

    private final static List<String> WHITE_LIST = List.of(
            "/api/v1/auth/access/token",
            "/api/v1/auth/refresh/token",
            "/api/v1/user/register",
            "/swagger-ui.*",
            "/auth/refreshToken");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (!isOpenUrl.apply(requestURI)) {
            String token = parseJwt(request);
            final AccessTokenService accessTokenService = JwtUtils.accessTokenService;
            if (accessTokenService.isValid(token)) {
               String email = accessTokenService.getSubject(token);
                //authService.
            }
        }
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        String prefix = "Bearer ";
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith(prefix)) {
            return headerAuth.substring(prefix.length());
        }
        return null;
    }

    private final static Function<String, Boolean> isOpenUrl = (url) -> WHITE_LIST.stream().anyMatch(url::matches);
}
