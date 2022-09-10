package com.example.trello_springboot.domains.auth;

import com.example.trello_springboot.domains.Auditable;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:53 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "user_id_workspace_id_auth_role_id_unique_key",
                columnNames = {"user_id", "workspaceId", "role_id"}
        )
})
public class AuthUserRight extends Auditable {

    @ManyToOne
    private AuthUser user;
    private Long workspaceId;
    @OneToOne
    private AuthRole role;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserRight(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, AuthUser user) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.user = user;
    }
}
