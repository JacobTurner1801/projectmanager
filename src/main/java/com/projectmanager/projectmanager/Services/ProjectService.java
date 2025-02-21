package com.projectmanager.projectmanager.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectmanager.projectmanager.Entities.Project;
import com.projectmanager.projectmanager.Entities.User;
import com.projectmanager.projectmanager.repositories.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    public Optional<Project> getProjectByName(String name) {
        return projectRepository.findByName(name);
    }

    public Page<Project> getAllProjects(Pageable table) {
        return projectRepository.findAll(table);
    }

    Optional<List<Project>> getProjectsCreatedBy(User createdBy) {
        return projectRepository.findByCreatedBy(createdBy);
    }

    Optional<List<Project>> getProjectsCreatedByUserId(Long createdById) {
        return projectRepository.findByCreatedByUserId(createdById);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id)
            .map(existingProject -> {
                existingProject.setName(updatedProject.getName());
                existingProject.setDescription(updatedProject.getDescription());
                return projectRepository.save(existingProject);
            })
            .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    }
}
