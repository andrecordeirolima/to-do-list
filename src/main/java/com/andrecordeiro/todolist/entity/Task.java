package com.andrecordeiro.todolist.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private boolean finished;
    private int priority;

    public Task(String name, String description, boolean finished, int priority) {
        this.name = name;
        this.description = description;
        this.finished = finished;
        this.priority = priority;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
