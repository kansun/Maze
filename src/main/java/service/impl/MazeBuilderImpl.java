package service.impl;

import model.Location;
import model.Maze;
import model.Square;
import service.MazeBuilder;

import java.util.HashMap;
import java.util.Map;

import static model.SquareType.fromLabel;

public class MazeBuilderImpl implements MazeBuilder {

    @Override
    public Maze build(char[][] input) {
        Map<Location, Square> squares = new HashMap<>();
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                char label = input[row][col];
                Location location = new Location(row, col);
                Square square = Square.newBuilder()
                        .withCoordinate(location)
                        .withType(fromLabel(label))
                        .build();
                squares.put(location, square);
            }
        }
        return new Maze(squares);
    }
}
