package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.Artifact;

import java.util.List;
import java.util.UUID;

public interface GetArtifactUseCase {

    Artifact findArtifact(UUID id);

    List<Artifact> findArtifacts(UUID sourceTask);

}
