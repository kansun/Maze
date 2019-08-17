package util;

import model.Location;
import model.Maze;
import model.Square;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toMap;
import static model.SquareType.END;
import static model.SquareType.MARKED;
import static model.SquareType.SPACE;
import static model.SquareType.START;
import static model.SquareType.WALL;

public enum TestResourcePool {

    SINGLE_ROW_MAZE_0(createSingleRowMaze_0(), createSolvedSingleRowMaze_0()),
    SINGLE_ROW_MAZE_1(createSingleRowMaze_1(), createSolvedSingleRowMaze_1()),
    SINGLE_ROW_MAZE_2(createSingleRowMaze_2(), createSolvedSingleRowMaze_2()),
    DIAGONAL_MAZE_2(createDiagonalMaze_1(), createSolvedDiagonalMaze_1()),
    COMPLEX_ROW_MAZE(createComplexMaze(), createSolvedComplexMaze());

    private final Maze unresolved;
    private final Maze solved;

    TestResourcePool(Maze unresolved, Maze solved) {
        this.unresolved = unresolved;
        this.solved = solved;
    }

    public Maze getUnresolved() {
        return unresolved;
    }

    public Maze getSolved() {
        return solved;
    }

    private static Maze createSingleRowMaze_0() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                //the row
                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(START).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(END).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createSolvedSingleRowMaze_0() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                //the row
                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(START).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(END).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createSingleRowMaze_1() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 4, null)).withType(WALL).build(),
                //the row
                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(START).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(END).build(),
                Square.newBuilder().withLocation(new Location(1, 4, null)).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 4, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createSolvedSingleRowMaze_1() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 4, null)).withType(WALL).build(),
                //the row
                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(START).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(MARKED).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(END).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 4, null)).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 4, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createSingleRowMaze_2() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 5, null)).withType(WALL).build(),
                //the row
                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(START).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 4, null)).withType(END).build(),
                Square.newBuilder().withLocation(new Location(1, 5, null)).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 5, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createSolvedSingleRowMaze_2() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                //top wall
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 5, null)).withType(WALL).build(),
                //the row
                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(START).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(MARKED).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(MARKED).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 4, null)).withType(END).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 5, null)).withType(WALL).build(),
                //bottom1 wall
                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 5, null)).withType(WALL).build()
        ));
        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createDiagonalMaze_1() {
        Set<Square> squares = new HashSet<>(Arrays.asList(

                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(END).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(START).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(3, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 3, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    private static Maze createSolvedDiagonalMaze_1() {
        Set<Square> squares = new HashSet<>(Arrays.asList(

                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(MARKED).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(END).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(START).withVisited(true).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(3, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 3, null)).withType(WALL).build()
        ));

        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }

    static Maze createComplexMaze() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 5, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 6, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 4, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(2, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(2, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(3, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 1, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(3, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 3, null)).withType(END).build(),
                Square.newBuilder().withLocation(new Location(3, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(3, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(4, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 1, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(4, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(4, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(5, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(5, 1, null)).withType(START).build(),
                Square.newBuilder().withLocation(new Location(5, 2, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(5, 3, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(5, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(5, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(5, 6, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(6, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 5, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 6, null)).withType(WALL).build()
        ));
        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }
    /*
     * #######
     * #...  #
     * #.#.# #
     * #.#E# #
     * #.### #
     * #S  # #
     * #######
    */
    static Maze createSolvedComplexMaze() {
        Set<Square> squares = new HashSet<>(Arrays.asList(
                Square.newBuilder().withLocation(new Location(0, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 5, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(0, 6, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(1, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(1, 1, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(1, 2, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(1, 3, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(1, 4, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(1, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(2, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 1, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(2, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 3, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(2, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(2, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(2, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(3, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 1, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(3, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 3, null)).withType(END).build(),
                Square.newBuilder().withLocation(new Location(3, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(3, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(3, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(4, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 1, null)).withType(MARKED).build(),
                Square.newBuilder().withLocation(new Location(4, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(4, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(4, 6, null)).withType(WALL).build(),


                Square.newBuilder().withLocation(new Location(5, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(5, 1, null)).withType(START).build(),
                Square.newBuilder().withLocation(new Location(5, 2, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(5, 3, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(5, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(5, 5, null)).withType(SPACE).build(),
                Square.newBuilder().withLocation(new Location(5, 6, null)).withType(WALL).build(),

                Square.newBuilder().withLocation(new Location(6, 0, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 1, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 2, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 3, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 4, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 5, null)).withType(WALL).build(),
                Square.newBuilder().withLocation(new Location(6, 6, null)).withType(WALL).build()
        ));
        Map<Location, Square> map = squares.stream().collect(toMap(s -> s.getLocation(), s -> s));
        return new Maze(map);
    }
}
