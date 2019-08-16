package util;

import model.Maze;
import model.Square;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static model.SquareType.END;
import static model.SquareType.SPACE;
import static model.SquareType.START;
import static model.SquareType.WALL;

public interface TestUtils {

    static Maze createExpectedSingleRowMaze() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withRow(0).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(1).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(3).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(5).withType(WALL).build(),
                //the row
                Square.newBuilder().withRow(1).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(1).withCol(1).withType(START).build(),
                Square.newBuilder().withRow(1).withCol(2).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(3).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(4).withType(END).build(),
                Square.newBuilder().withRow(1).withCol(5).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withRow(2).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(1).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(3).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(5).withType(WALL).build()
        ));
        return new Maze(squares);
    }

    static Maze createExpectedMaze() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                Square.newBuilder().withRow(0).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(1).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(3).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(5).withType(WALL).build(),
                Square.newBuilder().withRow(0).withCol(6).withType(WALL).build(),

                Square.newBuilder().withRow(1).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(1).withCol(1).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(2).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(3).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(4).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(5).withType(SPACE).build(),
                Square.newBuilder().withRow(1).withCol(6).withType(WALL).build(),


                Square.newBuilder().withRow(2).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(1).withType(SPACE).build(),
                Square.newBuilder().withRow(2).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(3).withType(SPACE).build(),
                Square.newBuilder().withRow(2).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(2).withCol(5).withType(SPACE).build(),
                Square.newBuilder().withRow(2).withCol(6).withType(WALL).build(),


                Square.newBuilder().withRow(3).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(3).withCol(1).withType(SPACE).build(),
                Square.newBuilder().withRow(3).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(3).withCol(3).withType(END).build(),
                Square.newBuilder().withRow(3).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(3).withCol(5).withType(SPACE).build(),
                Square.newBuilder().withRow(3).withCol(6).withType(WALL).build(),


                Square.newBuilder().withRow(4).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(4).withCol(1).withType(SPACE).build(),
                Square.newBuilder().withRow(4).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(4).withCol(3).withType(WALL).build(),
                Square.newBuilder().withRow(4).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(4).withCol(5).withType(SPACE).build(),
                Square.newBuilder().withRow(4).withCol(6).withType(WALL).build(),


                Square.newBuilder().withRow(5).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(5).withCol(1).withType(START).build(),
                Square.newBuilder().withRow(5).withCol(2).withType(SPACE).build(),
                Square.newBuilder().withRow(5).withCol(3).withType(SPACE).build(),
                Square.newBuilder().withRow(5).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(5).withCol(5).withType(SPACE).build(),
                Square.newBuilder().withRow(5).withCol(6).withType(WALL).build(),

                Square.newBuilder().withRow(6).withCol(0).withType(WALL).build(),
                Square.newBuilder().withRow(6).withCol(1).withType(WALL).build(),
                Square.newBuilder().withRow(6).withCol(2).withType(WALL).build(),
                Square.newBuilder().withRow(6).withCol(3).withType(WALL).build(),
                Square.newBuilder().withRow(6).withCol(4).withType(WALL).build(),
                Square.newBuilder().withRow(6).withCol(5).withType(WALL).build(),
                Square.newBuilder().withRow(6).withCol(6).withType(WALL).build()
        ));
        return new Maze(squares);
    }
}
