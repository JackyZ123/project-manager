package org.example.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exception to handle validation errors. Contains a map of error to message and is handled by all Rest Controllers
 * with {@link org.example.controller.RestControllerExceptionHandler}
 */
public class ValidationException extends RuntimeException {
    private final Map<String, List<String>> errors;
    private String delimiter = "\n";

    public ValidationException() {
        super("Validation failed!");
        this.errors = new HashMap<>();
    }

    /**
     * Gets the errors as a string by joining with a delimiter
     * @return The errors
     */
    public Map<String, String> getStringErrors() {
        Map<String, String> combinedErrors = new HashMap<>();

        for (String key : errors.keySet()) {
            combinedErrors.put(key, String.join(delimiter, errors.get(key)));
        }

        return combinedErrors;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public void addError(String error, String message) {
        if (!errors.containsKey(error)) {
            errors.put(error, List.of(message));
        } else {
            errors.get(error).add(message);
        }
    }

    public boolean isEmpty() {
        return errors.isEmpty();
    }

    /**
     * Merge errors with another {@code ValidationException}
     * @param other The other validation exception
     */
    public void merge(ValidationException other) {
        for (Map.Entry<String, List<String>> entry : other.getErrors().entrySet()) {
            if (!this.errors.containsKey(entry.getKey())) {
                this.errors.put(entry.getKey(), entry.getValue());
            } else {
                // if the error already exists we can add to it
                this.errors.get(entry.getKey()).addAll(entry.getValue());
            }
        }
    }
}
