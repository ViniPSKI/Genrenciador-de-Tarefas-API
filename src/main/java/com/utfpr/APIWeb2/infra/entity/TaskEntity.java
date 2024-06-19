package com.utfpr.APIWeb2.infra.entity;

import com.utfpr.APIWeb2.core.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TAB_TASK")
public class TaskEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "createdByID")
    private UserEntity createBy;

    @ManyToOne
    @JoinColumn(name = "responsibilityToID")
    private UserEntity responsibilityTo;

}
