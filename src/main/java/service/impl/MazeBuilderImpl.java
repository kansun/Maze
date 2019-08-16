package service.impl;

import model.Maze;
import model.Square;
import service.MazeBuilder;

import java.util.HashSet;
import java.util.Set;

import static model.SquareType.fromLabel;

public class MazeBuilderImpl implements MazeBuilder {

    @Override
    public Maze build(char[][] input) {
        Set<Square> squares = new HashSet<>();
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                char label = input[row][col];
                Square square = Square.newBuilder()
                        .withRow(row)
                        .withCol(col)
                        .withType(fromLabel(label))
                        .build();
                squares.add(square);
            }
        }
        return new Maze(squares);
    }
}
