package com.example.trello_springboot.config.security;

import com.example.trello_springboot.domains.auth.AuthUser;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:30 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Builder
public record SecurityUserDetails(AuthUser authUser) implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authUser.getUserRights()
                .stream()
                .map(authUserRight -> authUserRight.getRole().getAuthority())
                .distinct()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return authUser.getStatus().notEquals(AuthUser.Status.ACCOUNT_EXPIRED);
    }

    @Override
    public boolean isAccountNonLocked() {
        return authUser.getStatus().equals(AuthUser.Status.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return authUser.getStatus().notEquals(AuthUser.Status.CREDENTIALS_EXPIRED);
    }

    @Override
    public boolean isEnabled() {
        return authUser.isDeleted();
    }

    public Long getId() {
        return authUser.getId();
    }
}
