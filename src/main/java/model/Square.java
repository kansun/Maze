package model;

import java.util.Arrays;
import java.util.Optional;

import static java.lang.String.format;

public enum Square {

    WALL('#'),
    SPACE(' '),
    START('S'),
    END('E'),
    MARKED('.');

    private final char label;

    Square(char label) {
        this.label = label;
    }

    public static Square fromLabel(char c) {
        Optional<Square> match = Arrays.stream(values()).filter(t -> t.getLabel() == c).findFirst();
        return match.orElseThrow(() -> new IllegalArgumentException(format("Encountered an invalid character '%c'.", c)));
    }

    public char getLabel() {
        return label;
    }
}
