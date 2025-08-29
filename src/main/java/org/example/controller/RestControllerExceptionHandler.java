package org.example.controller;

import org.example.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to handle exceptions in rest controllers globally
 */
@RestControllerAdvice
public class RestControllerExceptionHandler {
    /**
     * Catches all Validation Exceptions in the controller and returns them to the frontend.
     * Errors should be in the form of {@code 'errorName': 'errorMessage'}.
     * @param e The error that is thrown
     * @return A json containing the status code and errors.
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(ValidationException e) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("errors", e.getStringErrors());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
