package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.core.ports.TaskService;
import com.utfpr.APIWeb2.core.usecase.GetTaskUseCase;

import java.util.List;
import java.util.UUID;

public class GetTaskUseCaseImpl implements GetTaskUseCase {

    private final TaskService taskService;

    public GetTaskUseCaseImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task getTask(UUID id) {
        return taskService.getTask(id);
    }

    @Override
    public List<Task> getListTask() {
        return taskService.listTasks();
    }
}
