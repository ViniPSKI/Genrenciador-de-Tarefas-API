package com.utfpr.APIWeb2.core.ports;

import com.utfpr.APIWeb2.core.domain.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task saveTask(Task task);

    Task getTask(UUID id);

    List<Task> listTasks();

    Task deleteTask(UUID id);

    Task editTask(UUID id, Task task);

}
