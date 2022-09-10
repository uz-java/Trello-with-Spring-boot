package com.example.trello_springboot.domains.auth;

import com.example.trello_springboot.domains.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:52 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthUserPasswordAudit extends Auditable {

    @Column(unique = true)
    private String oldPassword;
    @Column(nullable = false, unique = true)
    private String currentPassword;
    @ManyToOne
    private AuthUser authUser;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserPasswordAudit(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String oldPassword, String currentPassword, AuthUser authUser) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.oldPassword = oldPassword;
        this.currentPassword = currentPassword;
        this.authUser = authUser;
    }
}
