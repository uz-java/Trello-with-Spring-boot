package com.example.trello_springboot.domains.task;

import com.example.trello_springboot.domains.Auditable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:56 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskComment extends Auditable {
    private String message;
    @Enumerated(EnumType.STRING)
    private TaskCommentType taskCommentType;

    @Builder(builderMethodName = "childBuilder")
    public TaskComment(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String message, TaskCommentType taskCommentType) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.message = message;
        this.taskCommentType = taskCommentType;
    }

    public enum TaskCommentType {
        INFO, ERROR, SOLUTION;
    }
}
