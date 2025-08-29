package org.example.enums;

public enum ProjectState {
    COMPLETED,
    IN_PROGRESS,
    ON_HOLD,
    DROPPED;

    public static ProjectState fromString(String state) throws IllegalArgumentException {
        return switch (state.toLowerCase()) {
            case "completed" -> COMPLETED;
            case "in-progress" -> IN_PROGRESS;
            case "on-hold" -> ON_HOLD;
            case "dropped" -> DROPPED;
            default -> throw new IllegalArgumentException("Unknown project state: " + state);
        };
    }
}
