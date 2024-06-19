package com.utfpr.APIWeb2.infra.persistence.repository;

import com.utfpr.APIWeb2.infra.entity.ArtifactEntity;
import com.utfpr.APIWeb2.infra.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ArtifactRepository extends JpaRepository<ArtifactEntity, UUID> {

    List<ArtifactEntity> findArtifactEntityBySourceTask(TaskEntity sourceTask);
}
