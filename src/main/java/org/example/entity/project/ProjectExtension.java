package org.example.entity.project;

import jakarta.persistence.*;

@Entity
public abstract class ProjectExtension {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }
}
