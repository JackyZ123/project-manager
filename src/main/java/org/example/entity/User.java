package org.example.entity;

import jakarta.persistence.*;
import org.example.entity.project.Project;

import java.util.List;

@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL)
    private List<Project> projects;

    protected User() {
        // JPA required no args constructor
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
