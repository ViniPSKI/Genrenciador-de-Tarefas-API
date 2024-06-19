package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.Artifact;

import java.util.UUID;

public interface DeleteArtifactUseCase {

    Artifact deleteArtifact(UUID id);

}
