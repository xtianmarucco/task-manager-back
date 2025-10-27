package org.taskmanager.taskmanagerback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskmanager.taskmanagerback.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}