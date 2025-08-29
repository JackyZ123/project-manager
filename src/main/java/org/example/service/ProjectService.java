package org.example.service;

import org.example.entity.project.Project;
import org.example.enums.ProjectState;
import org.example.repository.ProjectRepository;
import org.example.validation.ProjectValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void addProject(String name, String description, String githubUrl, String state) {
        // TODO: owner
        ProjectValidation.validateProjectFields(name, description, githubUrl, state);

        Project project = new Project(
                null,
                name,
                description,
                githubUrl,
                ProjectState.fromString(state)
        );

        projectRepository.save(project);
    }
}
