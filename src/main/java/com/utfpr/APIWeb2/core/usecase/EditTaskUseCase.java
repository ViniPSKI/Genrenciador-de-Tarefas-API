package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.Task;

import java.util.UUID;

public interface EditTaskUseCase {

    Task editTask(UUID id, Task task);

}
