package maze.service.impl;

import maze.exception.ApplicationException;
import maze.exception.DataValidationException;
import maze.model.Square;
import maze.service.InputValidator;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static maze.exception.ApplicationException.MESSAGE_ILLEGAL_CHARS_TEMPLATE;
import static maze.exception.ApplicationException.MESSAGE_INCONSISTENT_WIDTHS;
import static java.lang.String.format;
import static java.util.Arrays.stream;

public class InputValidatorImpl implements InputValidator {

    @Override
    public void validate(Collection<String> lines) {
        Set<Integer> width = new HashSet<>();
        Collection<ApplicationException> errors = new LinkedHashSet<>();
        lines.forEach(line -> {
                    char[] lineChars = line.toCharArray();
                    width.add(line.length());
            String invalidChars;
            if ((invalidChars = checkChars(lineChars)).length() > 0) {
                UUID errorId = UUID.randomUUID();
                throw new DataValidationException(errorId, format(MESSAGE_ILLEGAL_CHARS_TEMPLATE, invalidChars));
            }

        });
        if (width.size() > 1) {
            UUID errorId = UUID.randomUUID();
            throw new DataValidationException(errorId, MESSAGE_INCONSISTENT_WIDTHS);
        }
    }

    private String checkChars(char[] target) {
        Square[] squares = Square.values();
        String invalidChars = "";
        for (char c : target) {
            boolean invalid = stream(squares).noneMatch(s -> s.getLabel() == c);
            if (invalid) {
                invalidChars += (invalidChars.length() > 0 ? ", " : "") + "'" + c + "'";
            }
        }
        return invalidChars;
    }
}
