package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.core.ports.TaskService;
import com.utfpr.APIWeb2.core.usecase.DeleteTaskUseCase;

import java.util.UUID;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskService taskService;

    public DeleteTaskUseCaseImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task deleteTask(UUID id) {
        return taskService.deleteTask(id);
    }
}
