package model;

import java.util.Objects;

public final class Square {

    private final Location location;
    private final SquareType type;
    private final boolean visited;

    private Square(Builder builder) {
        location = builder.location;
        type = builder.type;
        visited = builder.visited;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Square copy) {
        Builder builder = new Builder();
        builder.location = copy.getLocation();
        builder.type = copy.getType();
        builder.visited = copy.isVisited();
        return builder;
    }

    public Location getLocation() {
        return location;
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
        return null != getLocation() && getLocation().equals(square.getLocation()) &&
                getType() == square.getType()
                ;
    }

    @Override
    public int hashCode() {

        return Objects.hash(getLocation(), getType());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("row=").append(location.getRow());
        sb.append(", col=").append(location.getCol());
        sb.append(", type=").append(type);
        sb.append(", visited=").append(visited);
        sb.append('}');
        return sb.toString();
    }

    public static final class Builder {
        private Location location;
        private SquareType type;
        private boolean visited;

        private Builder() {
        }

        public Builder withLocation(Location val) {
            location = val;
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
