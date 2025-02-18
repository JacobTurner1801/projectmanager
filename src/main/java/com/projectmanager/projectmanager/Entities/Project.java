package com.projectmanager.projectmanager.Entities;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name="Projects", schema="projectsDbSchema")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable = false)
    private String name;
    private String description;

    @ManyToOne // Many projects to one user
    @JoinColumn(name = "created_by", nullable = false)  // Foreign key
    private User createdBy;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private Instant createdAt;
    private Date dueDate;
    private String status;

    public Project() {}

    public Project(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project proj = (Project) o;
        return Objects.equals(projectId, proj.projectId) && Objects.equals(name, proj.name);
    }
}
