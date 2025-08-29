package org.example.repository;

import org.example.entity.project.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class ProjectRepository implements CrudRepository<Project, Long> {
}
