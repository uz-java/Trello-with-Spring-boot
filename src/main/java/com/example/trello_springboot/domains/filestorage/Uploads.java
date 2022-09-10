package com.example.trello_springboot.domains.filestorage;

import com.example.trello_springboot.domains.Auditable;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Uploads extends Auditable {
    @Column(nullable = false)
    private String originalName;
    @Column(nullable = false)
    private String generateName;
    @Column(nullable = false)
    private String mimeType;
    @Column(nullable = false)
    private String path;
    private long size;
    private UploadsType type=UploadsType.UPLOADS_FILE;

    @Builder(builderMethodName = "childBuilder")
    public Uploads(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String originalName, String generateName, String mimeType, String path, long size, UploadsType type) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.originalName = originalName;
        this.generateName = generateName;
        this.mimeType = mimeType;
        this.path = path;
        this.size = size;
        this.type = type;
    }

    public enum UploadsType{
        UPLOADS_FILE,
        PROFILE_PICTURE,
        TZ,
        WORK_SPACE_DOC
    }
}
