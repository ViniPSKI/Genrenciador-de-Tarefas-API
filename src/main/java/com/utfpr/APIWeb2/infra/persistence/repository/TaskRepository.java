package com.utfpr.APIWeb2.infra.persistence.repository;

import com.utfpr.APIWeb2.infra.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {
}
