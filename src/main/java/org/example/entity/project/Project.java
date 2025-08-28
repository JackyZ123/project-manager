package org.example.entity.project;

import jakarta.persistence.*;
import org.example.entity.User;
import org.example.enums.ProjectState;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User owner;

    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String description;

    @Column(nullable=false)
    private LocalDateTime createdAt;
    @Column(nullable=false)
    private LocalDateTime updatedAt;

    @Column(nullable=false)
    private String githubRepoUrl;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private ProjectState state;

    @OneToMany(mappedBy="project", cascade=CascadeType.ALL)
    private List<ProjectExtension> extensions;

    protected Project() {
        // JPA required no-args constructor
    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getGithubRepoUrl() {
        return githubRepoUrl;
    }

    public ProjectState getState() {
        return state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setGithubRepoUrl(String githubRepoUrl) {
        this.githubRepoUrl = githubRepoUrl;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }
}
