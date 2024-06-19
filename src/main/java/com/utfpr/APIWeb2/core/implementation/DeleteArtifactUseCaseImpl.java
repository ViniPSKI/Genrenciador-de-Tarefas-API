package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Artifact;
import com.utfpr.APIWeb2.core.ports.ArtifactService;
import com.utfpr.APIWeb2.core.usecase.DeleteArtifactUseCase;

import java.util.UUID;

public class DeleteArtifactUseCaseImpl implements DeleteArtifactUseCase {

    private final ArtifactService artifactService;

    public DeleteArtifactUseCaseImpl(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @Override
    public Artifact deleteArtifact(UUID id) {
        return artifactService.delete(id);
    }
}
