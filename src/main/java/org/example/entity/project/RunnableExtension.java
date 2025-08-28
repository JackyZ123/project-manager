package org.example.entity.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class RunnableExtension extends ProjectExtension {
    @Column(nullable=false)
    private String executableUrl;

    protected RunnableExtension() {
        // JPA required no-args constructor
        super();
    }

    public void setExecutableUrl(String executableUrl) {
        this.executableUrl = executableUrl;
    }

    public String getExecutableUrl() {
        return executableUrl;
    }
}
