package com.utfpr.APIWeb2.infra.ports;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.core.ports.TaskService;
import com.utfpr.APIWeb2.infra.entity.TaskEntity;
import com.utfpr.APIWeb2.infra.persistence.converters.TaskEntityMapper;
import com.utfpr.APIWeb2.infra.persistence.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Repository
@RequiredArgsConstructor
public class TaskRepositoryService implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskEntityMapper taskEntityMapper;

    @Override
    public Task saveTask(Task task) {
        var taskEntity = taskEntityMapper.toEntity(task);
        var taskSave = taskRepository.save(taskEntity);
        return taskEntityMapper.toTask(taskEntity);
    }

    @Override
    public Task getTask(UUID id) {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
        return taskEntityMapper.toTask(taskEntityOptional.get());
    }

    @Override
    public List<Task> listTasks() {
        List<TaskEntity> taskEntityOptional = taskRepository.findAll();
        return taskEntityMapper.toTask(taskEntityOptional);
    }

    @Override
    public Task deleteTask(UUID id) {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);
        taskRepository.delete(taskEntityOptional.get());
        return taskEntityMapper.toTask(taskEntityOptional.get());
    }

    @Override
    public Task editTask(UUID id, Task task) {
        Optional<TaskEntity> taskEntityOptional = taskRepository.findById(id);

        var editTask = new Task();
        BeanUtils.copyProperties(task, editTask);
        editTask.setId(taskEntityOptional.get().getId());

        var taskSave = taskEntityMapper.toEntity(editTask);
        var taskSaved = taskRepository.save(taskSave);

        return taskEntityMapper.toTask(taskSaved);
    }

}
