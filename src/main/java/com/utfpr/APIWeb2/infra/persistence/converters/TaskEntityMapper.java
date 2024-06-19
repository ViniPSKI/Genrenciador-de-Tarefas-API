package com.utfpr.APIWeb2.infra.persistence.converters;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.infra.entity.TaskEntity;
import com.utfpr.APIWeb2.infra.entity.UserEntity;
import com.utfpr.APIWeb2.infra.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskEntityMapper {

    @Autowired
    private UserRepository userRepository;

    public TaskEntity toEntity(Task task){

        UserEntity createdByEntity = userRepository.findUserEntityByEmail(task.getCreateBY());
        UserEntity responsibilityToEntity = userRepository.findUserEntityByEmail(task.getResponsibilityTo());

        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                createdByEntity,
                responsibilityToEntity);
    }

    public Task toTask(TaskEntity taskEntity){
        return new Task(taskEntity.getId(), taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.getCreateBy().getEmail(), taskEntity.getResponsibilityTo().getEmail());
    }

    public List<Task> toTask(List<TaskEntity> taskEntityList){
        return taskEntityList.stream().map(this::toTask).collect(Collectors.toList());
    }

}
