package com.example.trello_springboot.domains.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:52 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String code;
    private String name;
    @Override
    public String getAuthority() {
        return "ROLE_"+code;
    }
}
