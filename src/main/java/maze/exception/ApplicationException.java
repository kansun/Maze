package maze.exception;

import java.util.UUID;

public abstract class ApplicationException extends RuntimeException {

    public static final String MESSAGE_INCONSISTENT_WIDTHS = "Rows with inconsistent widths detected.";
    public static final String MESSAGE_ILLEGAL_CHARS_TEMPLATE = "Illegal chars detected: [%s].";
    public static final String MESSAGE_ILLEGAL_WALL_CHARS_TEMPLATE = "Illegal chars detected in wall: [%s].";

    public ApplicationException(UUID errorId, String message, Throwable throwable) {
        super(errorId + ": " + message, throwable);
    }

    public ApplicationException(UUID errorId, String message) {
        super(errorId + ": " + message);
    }
}
