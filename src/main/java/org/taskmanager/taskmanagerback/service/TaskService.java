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

    public boolean deleteTask(Long id) {
        // Check existence first
        if (!taskRepository.existsById(id)) {
            return false;
        }
        taskRepository.deleteById(id);
        return true;
    }
    public Task createTask(Task task) {
        Task savedTask = taskRepository.save(task);
        System.out.println("📝 Tarea creada: " + savedTask.getTitle());
        return savedTask;
    }

}
