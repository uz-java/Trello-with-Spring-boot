package com.example.trello_springboot.domains.task;

import com.example.trello_springboot.domains.Auditable;
import com.example.trello_springboot.domains.auth.UserDetails;
import com.example.trello_springboot.domains.board.BoardLabel;
import com.example.trello_springboot.domains.filestorage.Uploads;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

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
public class Task extends Auditable {
    @Column(unique = true,nullable = false)
    private String title;
    private String description;
    private LocalDateTime begins;
    private LocalDateTime deadline;

    @OneToMany
    private Collection<Uploads> uploads;

    @OneToMany
    private Collection<TaskComment> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_details_id", referencedColumnName = "userId")
    )
    private Collection<UserDetails> members;

    @Column(unique = true, nullable = false,name = "task_order")
    private Integer order;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "board_label_id", referencedColumnName = "id")
    )
    private Collection<BoardLabel> labels;
    @Enumerated(EnumType.STRING)
    private TaskLevel level;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Builder(builderMethodName = "childBuilder")
    public Task(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, String description, LocalDateTime begins, LocalDateTime deadline, Collection<Uploads> uploads, Collection<TaskComment> comments, Collection<UserDetails> members, Integer order, Collection<BoardLabel> labels, TaskLevel level, TaskPriority priority) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.description = description;
        this.begins = begins;
        this.deadline = deadline;
        this.uploads = uploads;
        this.comments = comments;
        this.members = members;
        this.order = order;
        this.labels = labels;
        this.level = level;
        this.priority = priority;
    }

    public enum TaskLevel {
        EASY, MEDIUM, HARD;
    }

    public enum TaskPriority {
        LOW, MEDIUM, HIGH;
    }
}
