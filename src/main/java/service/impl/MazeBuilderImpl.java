package service.impl;

import model.Location;
import model.Maze;
import model.Square;
import service.MazeBuilder;

import java.util.HashMap;
import java.util.Map;

import static model.Square.fromLabel;

public class MazeBuilderImpl implements MazeBuilder {

    @Override
    public Maze build(char[][] input) {
        Map<Location, Square> squares = new HashMap<>();
        int width = 0;
        final int height = input.length;
        for (int row = 0; row < height; row++) {
            if (width == 0) {
                width = input[row].length;
            }
            for (int col = 0; col < width; col++) {
                char label = input[row][col];
                Location location = new Location(row, col);
                squares.put(location, fromLabel(label));
            }
        }
        return new Maze(squares, width, height);
    }
}
