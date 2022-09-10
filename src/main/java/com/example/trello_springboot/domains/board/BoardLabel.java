package com.example.trello_springboot.domains.board;

import com.example.trello_springboot.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:55 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardLabel extends Auditable {
    private String title;
    private String color;

    @Builder(builderMethodName = "childBuilder")
    public BoardLabel(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, String color) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.color = color;
    }
}
