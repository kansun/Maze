package model;

import java.util.Map;
import java.util.Objects;

import static java.util.Collections.emptyMap;
import static java.util.Collections.unmodifiableMap;
import static model.Square.END;
import static model.Square.START;

public final class Maze {

    private Location start;
    private Location end;
    private final Map<Location, Square> squares;

    public Maze(Map<Location, Square> squares) {
        this.squares = null == squares ? emptyMap() : unmodifiableMap(squares);
        this.squares.forEach((key, value) -> {
            if (START == value) {
                start = key;
            } else if (END == value) {
                end = key;
            }
        });
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
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
