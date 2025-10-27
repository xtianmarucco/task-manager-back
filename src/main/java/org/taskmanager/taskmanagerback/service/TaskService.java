package org.taskmanager.taskmanagerback.service;

import org.taskmanager.taskmanagerback.model.Task;
import org.taskmanager.taskmanagerback.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        System.out.println("📦 Tareas encontradas: " + tasks.size());
        return tasks;    }

}