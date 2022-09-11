package com.example.trello_springboot.dtos.user;

import com.example.trello_springboot.domains.auth.AuthUser;
import com.example.trello_springboot.dtos.GenericDto;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:00 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public class AuthUSerDTO extends GenericDto {
    private String username;
    private AuthUser.Status status;
}
