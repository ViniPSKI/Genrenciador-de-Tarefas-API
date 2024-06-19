package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.Task;

import java.util.List;
import java.util.UUID;

public interface GetTaskUseCase {

    Task getTask(UUID id);

    List<Task> getListTask();

}
