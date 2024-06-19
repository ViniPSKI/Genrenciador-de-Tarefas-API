package com.utfpr.APIWeb2.infra.converters;

import com.utfpr.APIWeb2.core.domain.Artifact;
import com.utfpr.APIWeb2.infra.DTO.ArtifactDto;
import org.springframework.stereotype.Component;

@Component
public class ArtifactMapper {

    public Artifact toSave(ArtifactDto artifactDto){
        return new Artifact(artifactDto.annotation(), artifactDto.createBy(), artifactDto.sourceTask());
    }

    public ArtifactDto toDto(Artifact artifact){
        return new ArtifactDto(artifact.getAnnotation(), artifact.getCreateBy(), artifact.getSourceTask());
    }

}
