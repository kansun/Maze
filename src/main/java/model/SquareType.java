package model;

import java.util.Arrays;
import java.util.Optional;

import static java.lang.String.format;

public enum SquareType {

    WALL('#'),
    SPACE(' '),
    START('S'),
    END('E'),
    MARKED('.');

    private final char label;

    SquareType(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }

    public static SquareType fromLabel(char c) {
        Optional<SquareType> match = Arrays.stream(values()).filter(t -> t.getLabel() == c).findFirst();
        return match.orElseThrow(() -> new IllegalArgumentException(format("Encountered an invalid character '%c'.", c)));
    }
}
