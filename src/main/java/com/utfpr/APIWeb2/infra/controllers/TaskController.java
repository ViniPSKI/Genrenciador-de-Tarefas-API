package com.utfpr.APIWeb2.infra.controllers;

import com.utfpr.APIWeb2.core.domain.Task;
import com.utfpr.APIWeb2.core.implementation.CreateTaskUseCaseImpl;
import com.utfpr.APIWeb2.core.usecase.DeleteTaskUseCase;
import com.utfpr.APIWeb2.core.usecase.EditTaskUseCase;
import com.utfpr.APIWeb2.core.usecase.GetTaskUseCase;
import com.utfpr.APIWeb2.infra.DTO.TaskDto;
import com.utfpr.APIWeb2.infra.converters.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("task")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class TaskController {

    public final CreateTaskUseCaseImpl createTaskUseCase;
    public final GetTaskUseCase getTaskUseCase;
    public final DeleteTaskUseCase deleteTaskUseCase;
    private final EditTaskUseCase editTaskUseCase;
    public final TaskMapper taskMapper;

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto){
        var taskSave = taskMapper.toSave(taskDto);
        var taskResponse = createTaskUseCase.createTask(taskSave);
        return taskMapper.toDto(taskResponse);
    }

    @GetMapping("/{id}")
    public TaskDto getTask(@PathVariable(value = "id") UUID id){
        return taskMapper.toDto(getTaskUseCase.getTask(id));
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return getTaskUseCase.getListTask();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") UUID id){
        var taskDeleted = deleteTaskUseCase.deleteTask(id);
        return ResponseEntity.ok().body(taskDeleted);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Object> editTask(@PathVariable(value = "id") UUID id, @RequestBody TaskDto taskDto){
        var taskEdit = taskMapper.toSave(taskDto);
        var editedTask = editTaskUseCase.editTask(id, taskEdit);
        return ResponseEntity.ok().body(taskMapper.toDto(editedTask));
    }

}
