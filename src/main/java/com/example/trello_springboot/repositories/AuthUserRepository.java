package com.example.trello_springboot.repositories;

import com.example.trello_springboot.domains.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 11:09 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, GenericRepository {
    Optional<AuthUser> findByUsername(String username);
}
