package com.projectmanager.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmanager.projectmanager.Entities.Project;
import com.projectmanager.projectmanager.Entities.User;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByName(String name);
    Optional<List<Project>> findByCreatedBy(User createdBy);
    Optional<List<Project>> findByCreatedByUserId(Long createdById);
}
