package service;

import model.ApplicationError;

import java.util.Collection;

public interface ApplicationErrorHandler {

    String MESSAGE_INCONSISTENT_WIDTH = "Rows with inconsistent width detected.";
    String MESSAGE_ILLEGAL_CHARS = "Illegal chars detected. ";

    void handleErrors(Collection<ApplicationError> errors);
}
