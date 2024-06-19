package com.utfpr.APIWeb2.infra.DTO;

import java.util.UUID;

public record ArtifactDto(String annotation, String createBy, UUID sourceTask) {
}
