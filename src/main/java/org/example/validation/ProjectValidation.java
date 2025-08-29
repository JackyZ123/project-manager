package org.example.validation;

import org.example.enums.ProjectState;
import org.example.exception.ValidationException;

import java.util.List;
import java.util.regex.Pattern;

public class ProjectValidation {
    private static final int PROJECT_NAME_MAX_LENGTH = 64;
    private static final Pattern PROJECT_NAME_PATTERN = Pattern.compile("^[A-Za-z0-9.,'!&()_-]+$");
    private static final int PROJECT_DESCRIPTION_MAX_LENGTH = 256;
    private static final Pattern GITHUB_URL_PATTERN = Pattern.compile(
            "^https://github\\.com/[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+(?:\\.git)?$"
    );

    public static void validateProjectName(String projectName) throws ValidationException {
        ValidationException validationException = new ValidationException();

        if (projectName == null || projectName.isEmpty()) {
            validationException.addError("project name", "Project name cannot be null or empty");
        } else {
            if (projectName.length() > PROJECT_NAME_MAX_LENGTH)
                validationException.addError("project name",
                        "Project name cannot exceed " + PROJECT_NAME_MAX_LENGTH + " characters");
            if (!PROJECT_NAME_PATTERN.matcher(projectName).matches())
                validationException.addError("project name",
                        "Project name can only contain letters, digits, commas, periods, apostrophes, hyphens, " +
                                "underscores, ampersands and brackets");
        }

        if (!validationException.isEmpty())
            throw validationException;
    }

    public static void validateProjectDescription(String projectDescription) throws ValidationException {
        ValidationException validationException = new ValidationException();

        if (projectDescription == null) {
            validationException.addError("project description", "Project description cannot be null");
        } else if (projectDescription.length() > PROJECT_DESCRIPTION_MAX_LENGTH) {
            validationException.addError("project description",
                    "Project description cannot exceed " + PROJECT_DESCRIPTION_MAX_LENGTH + " characters");
        }

        if (!validationException.isEmpty())
            throw validationException;
    }

    public static void validateProjectGitHubUrl(String githubUrl) throws ValidationException {
        ValidationException validationException = new ValidationException();

        if (githubUrl == null || githubUrl.isEmpty()) {
            validationException.addError("project github url", "GitHub URL cannot be null or empty");
        } else {
            if (!GITHUB_URL_PATTERN.matcher(githubUrl).matches())
                validationException.addError("project github url", "GitHub URL is not in a valid format");
        }

        if (!validationException.isEmpty())
            throw validationException;
    }

    public static void validateProjectState(String projectState) throws ValidationException {
        ValidationException validationException = new ValidationException();

        if (projectState == null || projectState.isEmpty()) {
            validationException.addError("project state", "Project state cannot be null or empty");
        } else {
            try {
                ProjectState.fromString(projectState);
            } catch (IllegalArgumentException e) {
                validationException.addError("project state", "Invalid project state");
            }
        }

        if (!validationException.isEmpty())
            throw validationException;
    }

    public static void validateProjectFields(String name,
                                             String description,
                                             String githubUrl,
                                             String state
    ) throws ValidationException {
        ValidationException validationException = new ValidationException();

        List<Runnable> runnables = List.of(
                () -> validateProjectName(name),
                () -> validateProjectDescription(description),
                () -> validateProjectGitHubUrl(githubUrl),
                () -> validateProjectState(state)
        );

        for (Runnable runnable : runnables) {
            try {
                runnable.run();
            } catch (ValidationException e) {
                validationException.merge(e);
            }
        }

        if (!validationException.isEmpty())
            throw validationException;
    }
}
