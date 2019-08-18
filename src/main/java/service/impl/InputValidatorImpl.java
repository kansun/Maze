package service.impl;

import model.ApplicationError;
import model.Square;
import service.ApplicationErrorHandler;
import service.InputValidator;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import static java.util.Arrays.stream;
import static service.ApplicationErrorHandler.MESSAGE_ILLEGAL_CHARS;
import static service.ApplicationErrorHandler.MESSAGE_INCONSISTENT_WIDTH;

public class InputValidatorImpl implements InputValidator {

    private final ApplicationErrorHandler applicationErrorHandler;

    public InputValidatorImpl(ApplicationErrorHandler applicationErrorHandler) {
        this.applicationErrorHandler = applicationErrorHandler;
    }

    @Override
    public void validate(Collection<String> lines) {
        Set<Integer> width = new HashSet<>();
        Collection<ApplicationError> errors = new LinkedHashSet<>();
        lines.forEach(line -> {
                    char[] lineChars = line.toCharArray();
                    width.add(line.length());
                    if (containsInvalidChars(lineChars)) {
                        errors.add(new ApplicationError(MESSAGE_ILLEGAL_CHARS));
                    }
                }
        );
        if (width.size() > 1) {
            errors.add(new ApplicationError(MESSAGE_INCONSISTENT_WIDTH));
        }
        applicationErrorHandler.handleErrors(errors);
    }

    private boolean containsInvalidChars(char[] target) {
        Square[] squares = Square.values();
        for (char c : target) {
            boolean invalid = stream(squares).noneMatch(s -> s.getLabel() == c);
            if (invalid) {
                return true;
            }
        }
        return false;
    }
}
