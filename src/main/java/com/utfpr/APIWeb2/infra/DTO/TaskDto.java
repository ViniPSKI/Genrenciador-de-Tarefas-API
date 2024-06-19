package com.utfpr.APIWeb2.infra.DTO;

import java.util.UUID;

public record TaskDto(UUID id, String title, String description, String createBy, String responsibilityTo) {
}
