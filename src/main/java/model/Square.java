package model;

import java.util.Objects;

public final class Square {

    private final int row;
    private final int col;
    private final SquareType type;
    private final boolean visited;

    private Square(Builder builder) {
        row = builder.row;
        col = builder.col;
        type = builder.type;
        visited = builder.visited;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Square copy) {
        Builder builder = new Builder();
        builder.row = copy.getRow();
        builder.col = copy.getCol();
        builder.type = copy.getType();
        builder.visited = copy.isVisited();
        return builder;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public SquareType getType() {
        return type;
    }

    public boolean isVisited() {
        return visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return getRow() == square.getRow() &&
                getCol() == square.getCol() &&
                getType() == square.getType() &&
                isVisited() == square.isVisited()
                ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getRow(), getCol(), getType(), isVisited());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("row=").append(row);
        sb.append(", col=").append(col);
        sb.append(", type=").append(type);
        sb.append(", visited=").append(visited);
        sb.append('}');
        return sb.toString();
    }

    public static final class Builder {
        private int row;
        private int col;
        private SquareType type;
        private boolean visited;

        private Builder() {
        }

        public Builder withRow(int val) {
            row = val;
            return this;
        }

        public Builder withCol(int val) {
            col = val;
            return this;
        }

        public Builder withType(SquareType val) {
            type = val;
            return this;
        }

        public Builder withVisited(boolean val) {
            visited = val;
            return this;
        }

        public Square build() {
            return new Square(this);
        }
    }
}
