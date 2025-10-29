package org.taskmanager.taskmanagerback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskmanager.taskmanagerback.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);

    List<Task> findByTitleContainingIgnoreCase(String title);

    List<Task> findByStatusAndTitleContainingIgnoreCase(String status, String title);
}

