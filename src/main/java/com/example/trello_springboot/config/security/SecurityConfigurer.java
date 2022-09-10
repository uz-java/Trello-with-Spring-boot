package com.example.trello_springboot.config.security;

import com.example.trello_springboot.config.security.jwt.JwtFilter;
import com.example.trello_springboot.services.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:29 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfigurer {
    private final AuthService authService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry
                .antMatchers(
                        "/api/v1/auth/access/token",
                        "/api/v1/auth/refresh/token",
                        "/api/v1/user/register","/swagger-ui/**",
                        "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated());
        http.sessionManagement(httpSecuritySessionManagementConfigurer ->
                httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(new JwtFilter(authService), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
