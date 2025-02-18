package com.projectmanager.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.projectmanager.Entities.Project;
import com.projectmanager.projectmanager.Entities.Task;
import com.projectmanager.projectmanager.Entities.User;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<List<Task>> findByProject(Project project);
    Optional<List<Task>> findByAssignedTo(User assignedUser);
}
