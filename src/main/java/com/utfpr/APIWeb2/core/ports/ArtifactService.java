package com.utfpr.APIWeb2.core.ports;

import com.utfpr.APIWeb2.core.domain.Artifact;

import java.util.List;
import java.util.UUID;

public interface ArtifactService {

    Artifact save(Artifact artifact);

    Artifact delete(UUID id);

    Artifact find(UUID id);

    List<Artifact> findArtifacts(UUID sourceTask);

}
