package maze.exception;

import java.util.UUID;

public class DataValidationException extends ApplicationException {

    public DataValidationException(UUID errorId, String message) {
        super(errorId, message);
    }
}
