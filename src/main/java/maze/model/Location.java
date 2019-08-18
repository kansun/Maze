package maze.model;

import java.util.Objects;

public final class Location {
    private final int row;
    private final int col;
    private final Location previous;

    public Location(int row, int col) {
        this(row, col, null);
    }

    public Location(int row, int col, Location previous) {
        this.row = row;
        this.col = col;
        this.previous = previous;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Location getPrevious() {
        return previous;
    }

    public Location locateNeighbour(Direction direction) {
        Location neighbourLocation = null;
        switch (direction) {
            case UP:
                neighbourLocation = new Location(this.getRow() - 1, this.getCol(), this);
                break;
            case RIGHT:
                neighbourLocation = new Location(this.getRow(), this.getCol() + 1, this);
                break;
            case DOWN:
                neighbourLocation = new Location(this.getRow() + 1, this.getCol(), this);
                break;
            case LEFT:
                neighbourLocation = new Location(this.getRow(), this.getCol() - 1, this);
                break;

        }
        return neighbourLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location that = (Location) o;
        return getRow() == that.getRow() &&
                getCol() == that.getCol()
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Location{");
        sb.append("row=").append(row);
        sb.append(", col=").append(col);
        sb.append('}');
        return sb.toString();
    }
}
