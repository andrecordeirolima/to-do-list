package com.andrecordeiro.todolist.service;

import com.andrecordeiro.todolist.entity.Task;
import com.andrecordeiro.todolist.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> create(Task task) {
        taskRepository.save(task);
        return list();
    }

    public List<Task> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return taskRepository.findAll(sort);
    }

    public List<Task> update(Task task) {
        taskRepository.save(task);
        return list();
    }

    public List<Task> delete(Long id) {
        taskRepository.deleteById(id);
        return list();
    }
}
