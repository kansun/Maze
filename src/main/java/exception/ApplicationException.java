package exception;

import java.util.UUID;

public abstract class ApplicationException extends RuntimeException {

    public static final String MESSAGE_INCONSISTENT_WIDTHS = "Rows with inconsistent widths detected.";
    public static final String MESSAGE_ILLEGAL_CHARS_TEMPLATE = "Illegal chars detected: [%s].";

    private final UUID errorId;

    public ApplicationException(UUID errorId, String message, Throwable throwable) {
        super(errorId + ": " + message, throwable);
        this.errorId = errorId;
    }

    public ApplicationException(UUID errorId, String message) {
        super(errorId + ": " + message);
        this.errorId = errorId;
    }

    public UUID getErrorId() {
        return errorId;
    }
}
