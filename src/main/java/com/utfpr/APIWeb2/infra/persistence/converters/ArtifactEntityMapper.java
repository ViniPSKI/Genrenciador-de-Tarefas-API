package com.utfpr.APIWeb2.infra.persistence.converters;

import com.utfpr.APIWeb2.core.domain.Artifact;
import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.infra.entity.ArtifactEntity;
import com.utfpr.APIWeb2.infra.entity.TaskEntity;
import com.utfpr.APIWeb2.infra.entity.UserEntity;
import com.utfpr.APIWeb2.infra.persistence.repository.TaskRepository;
import com.utfpr.APIWeb2.infra.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtifactEntityMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    public ArtifactEntity toEntity(Artifact artifact){

        UserEntity userEntity = userRepository.findUserEntityByEmail(artifact.getCreateBy());

        TaskEntity task = taskRepository.findById(artifact.getSourceTask()).orElseThrow();

        return new ArtifactEntity(artifact.getId(), artifact.getAnnotation(), userEntity, task);
    }

    public Artifact toArtifact(ArtifactEntity artifactEntity){
        return new Artifact(artifactEntity.getAnnotation(), artifactEntity.getCreateBy().getEmail(), artifactEntity.getSourceTask().getId());
    }

    public List<Artifact> toArtifact(List<ArtifactEntity> artifactEntityList){
        return artifactEntityList.stream().map(this::toArtifact).collect(Collectors.toList());
    }

}
