package com.utfpr.APIWeb2.infra.converters;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.infra.DTO.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDto toDto(Task task){
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getCreateBY(), task.getResponsibilityTo());
    }

    public Task toSave(TaskDto taskDto){
        return new Task(taskDto.id(), taskDto.title(), taskDto.description(), taskDto.createBy(), taskDto.responsibilityTo());
    }

}
