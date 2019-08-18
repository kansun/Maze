package maze.service.impl;

import maze.exception.ApplicationException;
import maze.service.GlobalExceptionHandler;

import java.util.Collection;

public class ExceptionHandlerImpl implements GlobalExceptionHandler {

    @Override
    public void handle(Collection<ApplicationException> exceptions) {
        if (exceptions != null && !exceptions.isEmpty()) {
            exceptions.stream().forEach(e -> {
                System.out.println(String.format("[ERROR]: %s", e.getMessage()));
                e.printStackTrace();
            });
        }
        throw new IllegalStateException("System exited due to application exceptions.");
    }
}
