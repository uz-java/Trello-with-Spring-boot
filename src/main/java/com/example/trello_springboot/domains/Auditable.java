package com.example.trello_springboot.domains;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:51 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditListener.class)
public class Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,columnDefinition = "smallint default 0")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

    @CreationTimestamp
    @CreatedDate
    @Column(nullable = false,columnDefinition = "timestamp default current_timestamp",updatable = false)
    private LocalDateTime createdAt;
    @CreatedBy
    @Column(nullable = false,updatable = false)
    private Long createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private Long updatedBy;
}
