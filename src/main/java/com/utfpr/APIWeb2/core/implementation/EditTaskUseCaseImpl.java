package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.core.ports.TaskService;
import com.utfpr.APIWeb2.core.usecase.EditTaskUseCase;

import java.util.UUID;

public class EditTaskUseCaseImpl  implements EditTaskUseCase {

    private final TaskService taskService;

    public EditTaskUseCaseImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task editTask(UUID id,Task task) {
        return taskService.editTask(id, task);
    }
}
