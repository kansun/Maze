package service.impl;

import model.ApplicationError;
import service.ApplicationErrorHandler;

import java.util.Collection;

public class ErrorHandlerImpl implements ApplicationErrorHandler {

    @Override
    public void handleErrors(Collection<ApplicationError> errors) {
        errors.stream().forEach(e -> System.out.println(e.getMessage()));
        System.exit(1);
    }
}
