package model;

import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyMap;
import static java.util.Collections.unmodifiableMap;
import static model.SquareType.END;
import static model.SquareType.START;

public final class Maze {

    private Square start;
    private Square end;
    private final Map<Location, Square> squares;

    public Maze(Map<Location, Square> squares) {
        this.squares = null == squares ? emptyMap() : unmodifiableMap(squares);
        this.squares.values().forEach(square -> {
            if (START == square.getType()) {
                start = square;
            } else if (END == square.getType()) {
                end = square;
            }
        });
    }

    public Square getStart() {
        return start;
    }

    public Square getEnd() {
        return end;
    }

    public Map<Location, Square> getSquares() {
        return null == squares ? emptyMap() : unmodifiableMap(squares);
    }

    public Square locateSquare(Location location) {
        return squares.get(location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Maze maze = (Maze) o;
        return Objects.equals(getSquares(), maze.getSquares()) &&
                Objects.equals(getStart(), maze.getStart()) &&
                Objects.equals(getEnd(), maze.getEnd())
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSquares(), getStart(), getEnd());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Maze{");
        sb.append("squares=").append(squares);
        sb.append('}');
        return sb.toString();
    }
}
