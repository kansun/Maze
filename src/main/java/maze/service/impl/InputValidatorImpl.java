package maze.service.impl;

import maze.exception.DataValidationException;
import maze.model.Square;
import maze.service.InputValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static maze.exception.ApplicationException.MESSAGE_ILLEGAL_CHARS_TEMPLATE;
import static maze.exception.ApplicationException.MESSAGE_ILLEGAL_WALL_CHARS_TEMPLATE;
import static maze.exception.ApplicationException.MESSAGE_INCONSISTENT_WIDTHS;

public class InputValidatorImpl implements InputValidator {

    @Override
    public void validate(Collection<String> input) {
        Set<Integer> widths = new HashSet<>();
        List<String> lines = new ArrayList<>(input);
        for (int row = 0; row < lines.size(); row++) {
            String line = lines.get(row);
            char[] lineChars = line.toCharArray();
            if (row == 0 || row == lines.size() - 1) {
                checkWallChars(lineChars);
            }
            int lineWidth = line.length();
            checkWallChars(lineChars[0], lineChars[lineWidth - 1]);
            checkSquareChars(lineChars);
            widths.add(lineWidth);
        }
        if (widths.size() > 1) {
            UUID errorId = UUID.randomUUID();
            throw new DataValidationException(errorId, MESSAGE_INCONSISTENT_WIDTHS);
        }
    }

    private void checkSquareChars(char[] target) {
        Square[] squares = Square.values();
        String invalidChars = "";
        for (char c : target) {
            boolean invalid = stream(squares).noneMatch(s -> s.getLabel() == c);
            if (invalid) {
                invalidChars += append(invalidChars, c);
            }
        }
        respond(invalidChars, MESSAGE_ILLEGAL_CHARS_TEMPLATE);
    }

    private void checkWallChars(char... target) {
        String invalidChars = "";
        for (char c : target) {
            if (Square.WALL.getLabel() != c) {
                invalidChars += append(invalidChars, c);
            }
        }
        respond(invalidChars, MESSAGE_ILLEGAL_WALL_CHARS_TEMPLATE);
    }

    private String append(String invalidChars, char c) {
        return (invalidChars.length() > 0 ? ", " : "") + "'" + c + "'";
    }

    private void respond(String invalidChars, String errorMessageTemplate) {
        if (invalidChars.length() > 0) {
            UUID errorId = UUID.randomUUID();
            throw new DataValidationException(errorId, format(errorMessageTemplate, invalidChars));
        }
    }
}
