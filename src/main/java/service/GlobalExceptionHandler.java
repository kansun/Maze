package service;

import exception.ApplicationException;

import java.util.Collection;

public interface GlobalExceptionHandler {

    void handle(Collection<ApplicationException> exceptions);
}
