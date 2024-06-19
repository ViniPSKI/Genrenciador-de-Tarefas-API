package com.utfpr.APIWeb2.infra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ARTIFACT")
public class ArtifactEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String annotation;

    @ManyToOne
    @JoinColumn(name = "createdByID")
    private UserEntity createBy;

    @ManyToOne
    @JoinColumn(name = "sourceTask")
    private TaskEntity sourceTask;
}
