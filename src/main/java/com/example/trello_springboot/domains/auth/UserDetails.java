package com.example.trello_springboot.domains.auth;

import com.example.trello_springboot.domains.filestorage.Uploads;
import lombok.*;

import javax.persistence.*;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:53 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_detail")
public class UserDetails {
    @Id
    @Column(unique = true,nullable = false)
    private Long userId;

    @OneToOne(targetEntity = Uploads.class)
    private Uploads userProfilePicture;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String patronymic;

    private String fullName;
}
