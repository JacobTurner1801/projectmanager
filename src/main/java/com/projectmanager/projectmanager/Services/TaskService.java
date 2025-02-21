package com.projectmanager.projectmanager.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.projectmanager.Entities.Project;
import com.projectmanager.projectmanager.Entities.Task;
import com.projectmanager.projectmanager.Entities.User;
import com.projectmanager.projectmanager.repositories.TaskRepository;

import java.time.Instant;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<List<Task>> getTaskByProject(Project project) {
        return taskRepository.findByProject(project);
    }

    public Optional<List<Task>> getTaskByUser(User assignedUser) {
        return taskRepository.findByAssignedTo(assignedUser);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id)
            .map(existingTask -> {
                existingTask.setTitle(updatedTask.getTitle());
                existingTask.setDescription(updatedTask.getDescription());
                existingTask.setStatus(updatedTask.getStatus());
                existingTask.setDueDate(updatedTask.getDueDate());
                existingTask.setAssignedTo(updatedTask.getAssignedTo());
                existingTask.setUpdatedAt(Instant.now());
                return taskRepository.save(existingTask);
            })
            .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
}
