package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Artifact;
import com.utfpr.APIWeb2.core.ports.ArtifactService;
import com.utfpr.APIWeb2.core.usecase.GetArtifactUseCase;

import java.util.List;
import java.util.UUID;

public class GetArtifactUseCaseImpl implements GetArtifactUseCase{

    private final ArtifactService artifactService;

    public GetArtifactUseCaseImpl(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @Override
    public Artifact findArtifact(UUID id) {
        return artifactService.find(id);
    }

    @Override
    public List<Artifact> findArtifacts(UUID sourceTask) {
        return artifactService.findArtifacts(sourceTask);
    }
}
