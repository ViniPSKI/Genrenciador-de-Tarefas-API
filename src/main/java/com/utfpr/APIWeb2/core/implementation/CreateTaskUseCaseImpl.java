package com.utfpr.APIWeb2.core.implementation;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.core.ports.TaskService;
import com.utfpr.APIWeb2.core.usecase.CreateTaskUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskService taskService;

    public CreateTaskUseCaseImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task createTask(Task task) {
        return taskService.saveTask(task);
    }

}
