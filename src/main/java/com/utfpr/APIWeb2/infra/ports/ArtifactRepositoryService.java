package com.utfpr.APIWeb2.infra.ports;

import com.utfpr.APIWeb2.core.domain.Artifact;
import com.utfpr.APIWeb2.core.ports.ArtifactService;
import com.utfpr.APIWeb2.infra.entity.ArtifactEntity;
import com.utfpr.APIWeb2.infra.entity.TaskEntity;
import com.utfpr.APIWeb2.infra.persistence.converters.ArtifactEntityMapper;
import com.utfpr.APIWeb2.infra.persistence.repository.ArtifactRepository;
import com.utfpr.APIWeb2.infra.persistence.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Repository
@RequiredArgsConstructor
public class ArtifactRepositoryService implements ArtifactService {

    private final ArtifactRepository artifactRepository;
    private final ArtifactEntityMapper artifactEntityMapper;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Artifact save(Artifact artifact) {
        var artifactEntity = artifactEntityMapper.toEntity(artifact);
        var artifactSave = artifactRepository.save(artifactEntity);
        return artifactEntityMapper.toArtifact(artifactEntity);
    }

    @Override
    public Artifact delete(UUID id) {
        Optional<ArtifactEntity> optionalArtifactEntity = artifactRepository.findById(id);
        artifactRepository.delete(optionalArtifactEntity.get());
        return artifactEntityMapper.toArtifact(optionalArtifactEntity.get());
    }

    @Override
    public Artifact find(UUID id) {
        Optional<ArtifactEntity> optionalArtifactEntity = artifactRepository.findById(id);
        return artifactEntityMapper.toArtifact(optionalArtifactEntity.get());
    }

    @Override
    public List<Artifact> findArtifacts(UUID sourceTask) {
        TaskEntity task = taskRepository.findById(sourceTask).orElseThrow();
        List<ArtifactEntity> artifactList = (List<ArtifactEntity>) artifactRepository.findArtifactEntityBySourceTask(task);
        return artifactEntityMapper.toArtifact(artifactList);
    }
}
