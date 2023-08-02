package com.andrecordeiro.todolist.repository;

import com.andrecordeiro.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
