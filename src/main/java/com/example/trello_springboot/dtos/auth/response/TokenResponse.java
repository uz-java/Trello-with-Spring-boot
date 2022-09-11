package com.example.trello_springboot.dtos.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:02 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Data
@Builder
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String refreshToken;
    private String username;
}
