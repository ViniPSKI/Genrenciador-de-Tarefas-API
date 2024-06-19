package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Artifact;
import com.utfpr.APIWeb2.core.ports.ArtifactService;
import com.utfpr.APIWeb2.core.usecase.CreateArtifactUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateArtifactUseCaseImpl implements CreateArtifactUseCase {

    private ArtifactService artifactService;

    public CreateArtifactUseCaseImpl(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @Override
    public Artifact createArtifact(Artifact artifact) {
        return artifactService.save(artifact);
    }
}
