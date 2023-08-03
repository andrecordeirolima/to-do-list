package com.andrecordeiro.todolist.controller;

import com.andrecordeiro.todolist.entity.Task;
import com.andrecordeiro.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    List<Task> create(@RequestBody Task task){
        return taskService.create(task);

    }
    @GetMapping
    List<Task> list() {
        return taskService.list();
    }

    @PutMapping
    List<Task> update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("{id}")
    List<Task> delete(@PathVariable("id") Long id) {
        return taskService.delete(id);
    }
}
