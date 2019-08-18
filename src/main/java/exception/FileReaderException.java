package exception;

import java.util.UUID;

public class FileReaderException extends ApplicationException {

    public FileReaderException(UUID errorId, String message, Throwable throwable) {
        super(errorId, message, throwable);
    }
}
