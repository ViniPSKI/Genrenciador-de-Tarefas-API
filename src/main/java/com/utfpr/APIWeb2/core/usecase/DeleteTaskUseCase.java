package com.utfpr.APIWeb2.core.usecase;

import com.utfpr.APIWeb2.core.domain.Task;

import java.util.UUID;

public interface DeleteTaskUseCase {

    Task deleteTask(UUID id);

}
