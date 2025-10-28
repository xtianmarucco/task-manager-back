package org.taskmanager.taskmanagerback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.taskmanagerback.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring automáticamente implementa esta query:
    Optional<User> findByEmail(String email);
}