package model;

import java.util.Objects;
import java.util.Set;

import static java.util.Collections.emptySet;
import static java.util.Collections.unmodifiableSet;

public final class Maze {

    private final Set<Square> squares;

    public Maze(Set<Square> squares) {
        this.squares = null == squares ? emptySet() : unmodifiableSet(squares);
    }

    public Set<Square> getSquares() {
        return null == squares ? emptySet() : unmodifiableSet(squares);
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
        return Objects.equals(getSquares(), maze.getSquares());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSquares());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Maze{");
        sb.append("squares=").append(squares);
        sb.append('}');
        return sb.toString();
    }
}
