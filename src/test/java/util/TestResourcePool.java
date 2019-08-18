package util;

import model.Location;
import model.Maze;
import model.Square;

import java.util.HashMap;
import java.util.Map;

import static model.Square.END;
import static model.Square.MARKED;
import static model.Square.SPACE;
import static model.Square.START;
import static model.Square.WALL;
import static util.TestConstants.LOCATION_00;
import static util.TestConstants.LOCATION_01;
import static util.TestConstants.LOCATION_02;
import static util.TestConstants.LOCATION_03;
import static util.TestConstants.LOCATION_04;
import static util.TestConstants.LOCATION_05;
import static util.TestConstants.LOCATION_06;
import static util.TestConstants.LOCATION_10;
import static util.TestConstants.LOCATION_11;
import static util.TestConstants.LOCATION_12;
import static util.TestConstants.LOCATION_13;
import static util.TestConstants.LOCATION_14;
import static util.TestConstants.LOCATION_15;
import static util.TestConstants.LOCATION_16;
import static util.TestConstants.LOCATION_20;
import static util.TestConstants.LOCATION_21;
import static util.TestConstants.LOCATION_22;
import static util.TestConstants.LOCATION_23;
import static util.TestConstants.LOCATION_24;
import static util.TestConstants.LOCATION_25;
import static util.TestConstants.LOCATION_26;
import static util.TestConstants.LOCATION_30;
import static util.TestConstants.LOCATION_31;
import static util.TestConstants.LOCATION_32;
import static util.TestConstants.LOCATION_33;
import static util.TestConstants.LOCATION_34;
import static util.TestConstants.LOCATION_35;
import static util.TestConstants.LOCATION_36;
import static util.TestConstants.LOCATION_40;
import static util.TestConstants.LOCATION_41;
import static util.TestConstants.LOCATION_42;
import static util.TestConstants.LOCATION_43;
import static util.TestConstants.LOCATION_44;
import static util.TestConstants.LOCATION_45;
import static util.TestConstants.LOCATION_46;
import static util.TestConstants.LOCATION_50;
import static util.TestConstants.LOCATION_51;
import static util.TestConstants.LOCATION_52;
import static util.TestConstants.LOCATION_53;
import static util.TestConstants.LOCATION_54;
import static util.TestConstants.LOCATION_55;
import static util.TestConstants.LOCATION_56;
import static util.TestConstants.LOCATION_60;
import static util.TestConstants.LOCATION_61;
import static util.TestConstants.LOCATION_62;
import static util.TestConstants.LOCATION_63;
import static util.TestConstants.LOCATION_64;
import static util.TestConstants.LOCATION_65;
import static util.TestConstants.LOCATION_66;

public enum TestResourcePool {

    SINGLE_ROW_MAZE_0(givenSingleRowMaze_0(), thenExpectSolvedSingleRowMaze_0()),
    SINGLE_ROW_MAZE_1(givenSingleRowMaze_1(), thenExpectSolvedSingleRowMaze_1()),
    SINGLE_ROW_MAZE_2(givenSingleRowMaze_2(), thenExpectSolvedSingleRowMaze_2()),
    DIAGONAL_MAZE_2(givenDiagonalMaze_1(), thenExpectSolvedDiagonalMaze_1()),
    COMPLEX_ROW_MAZE(givenComplexMaze(), thenExpectSolvedComplexMaze());

    private final Maze unresolved;
    private final Maze solved;

    TestResourcePool(Maze unresolved, Maze solved) {
        this.unresolved = unresolved;
        this.solved = solved;
    }

    private static Maze givenSingleRowMaze_0() {
        Map<Location, Square> map = new HashMap<>();
        //top wall
        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        //the row
        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, START);
        map.put(LOCATION_12, END);
        map.put(LOCATION_13, WALL);
        //bottom1 wall
        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, WALL);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);

        return new Maze(map);
    }

    private static Maze thenExpectSolvedSingleRowMaze_0() {
        Map<Location, Square> map = new HashMap<>();
        //top wall
        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        //the row
        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, START);
        map.put(LOCATION_12, END);
        map.put(LOCATION_13, WALL);
        //bottom1 wall
        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, WALL);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);

        return new Maze(map);
    }

    private static Maze givenSingleRowMaze_1() {
        Map<Location, Square> map = new HashMap<>();
        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        map.put(LOCATION_04, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, START);
        map.put(LOCATION_12, SPACE);
        map.put(LOCATION_13, END);
        map.put(LOCATION_14, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, WALL);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);
        map.put(LOCATION_24, WALL);

        return new Maze(map);
    }

    private static Maze thenExpectSolvedSingleRowMaze_1() {
        Map<Location, Square> map = new HashMap<>();

        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        map.put(LOCATION_04, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, START);
        map.put(LOCATION_12, MARKED);
        map.put(LOCATION_13, END);
        map.put(LOCATION_14, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, WALL);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);
        map.put(LOCATION_24, WALL);

        return new Maze(map);
    }

    private static Maze givenSingleRowMaze_2() {
        Map<Location, Square> map = new HashMap<>();

        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        map.put(LOCATION_04, WALL);
        map.put(LOCATION_05, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, START);
        map.put(LOCATION_12, SPACE);
        map.put(LOCATION_13, SPACE);
        map.put(LOCATION_14, END);
        map.put(LOCATION_15, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, WALL);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);
        map.put(LOCATION_24, WALL);
        map.put(LOCATION_25, WALL);

        return new Maze(map);
    }

    private static Maze thenExpectSolvedSingleRowMaze_2() {
        Map<Location, Square> map = new HashMap<>();

        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        map.put(LOCATION_04, WALL);
        map.put(LOCATION_05, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, START);
        map.put(LOCATION_12, MARKED);
        map.put(LOCATION_13, MARKED);
        map.put(LOCATION_14, END);
        map.put(LOCATION_15, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, WALL);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);
        map.put(LOCATION_24, WALL);
        map.put(LOCATION_25, WALL);

        return new Maze(map);
    }

    private static Maze givenDiagonalMaze_1() {
        Map<Location, Square> map = new HashMap<>();

        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, SPACE);
        map.put(LOCATION_12, END);
        map.put(LOCATION_13, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, START);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);

        map.put(LOCATION_30, WALL);
        map.put(LOCATION_31, WALL);
        map.put(LOCATION_32, WALL);
        map.put(LOCATION_33, WALL);

        return new Maze(map);
    }

    private static Maze thenExpectSolvedDiagonalMaze_1() {
        Map<Location, Square> map = new HashMap<>();

        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, MARKED);
        map.put(LOCATION_12, END);
        map.put(LOCATION_13, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, START);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, WALL);

        map.put(LOCATION_30, WALL);
        map.put(LOCATION_31, WALL);
        map.put(LOCATION_32, WALL);
        map.put(LOCATION_33, WALL);

        return new Maze(map);
    }

    static Maze givenComplexMaze() {
        Map<Location, Square> map = new HashMap<>();
        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        map.put(LOCATION_04, WALL);
        map.put(LOCATION_05, WALL);
        map.put(LOCATION_06, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, SPACE);
        map.put(LOCATION_12, SPACE);
        map.put(LOCATION_13, SPACE);
        map.put(LOCATION_14, SPACE);
        map.put(LOCATION_15, SPACE);
        map.put(LOCATION_16, WALL);

        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, SPACE);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, SPACE);
        map.put(LOCATION_24, WALL);
        map.put(LOCATION_25, SPACE);
        map.put(LOCATION_26, WALL);

        map.put(LOCATION_30, WALL);
        map.put(LOCATION_31, SPACE);
        map.put(LOCATION_32, WALL);
        map.put(LOCATION_33, END);
        map.put(LOCATION_34, WALL);
        map.put(LOCATION_35, SPACE);
        map.put(LOCATION_36, WALL);

        map.put(LOCATION_40, WALL);
        map.put(LOCATION_41, SPACE);
        map.put(LOCATION_42, WALL);
        map.put(LOCATION_43, WALL);
        map.put(LOCATION_44, WALL);
        map.put(LOCATION_45, SPACE);
        map.put(LOCATION_46, WALL);

        map.put(LOCATION_50, WALL);
        map.put(LOCATION_51, START);
        map.put(LOCATION_52, SPACE);
        map.put(LOCATION_53, SPACE);
        map.put(LOCATION_54, WALL);
        map.put(LOCATION_55, SPACE);
        map.put(LOCATION_56, WALL);

        map.put(LOCATION_60, WALL);
        map.put(LOCATION_61, WALL);
        map.put(LOCATION_62, WALL);
        map.put(LOCATION_63, WALL);
        map.put(LOCATION_64, WALL);
        map.put(LOCATION_65, WALL);
        map.put(LOCATION_66, WALL);

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
    static Maze thenExpectSolvedComplexMaze() {
        Map<Location, Square> map = new HashMap<>();
        map.put(LOCATION_00, WALL);
        map.put(LOCATION_01, WALL);
        map.put(LOCATION_02, WALL);
        map.put(LOCATION_03, WALL);
        map.put(LOCATION_04, WALL);
        map.put(LOCATION_05, WALL);
        map.put(LOCATION_06, WALL);

        map.put(LOCATION_10, WALL);
        map.put(LOCATION_11, MARKED);
        map.put(LOCATION_12, MARKED);
        map.put(LOCATION_13, MARKED);
        map.put(LOCATION_14, SPACE);
        map.put(LOCATION_15, SPACE);
        map.put(LOCATION_16, WALL);


        map.put(LOCATION_20, WALL);
        map.put(LOCATION_21, MARKED);
        map.put(LOCATION_22, WALL);
        map.put(LOCATION_23, MARKED);
        map.put(LOCATION_24, WALL);
        map.put(LOCATION_25, SPACE);
        map.put(LOCATION_26, WALL);


        map.put(LOCATION_30, WALL);
        map.put(LOCATION_31, MARKED);
        map.put(LOCATION_32, WALL);
        map.put(LOCATION_33, END);
        map.put(LOCATION_34, WALL);
        map.put(LOCATION_35, SPACE);
        map.put(LOCATION_36, WALL);


        map.put(LOCATION_40, WALL);
        map.put(LOCATION_41, MARKED);
        map.put(LOCATION_42, WALL);
        map.put(LOCATION_43, WALL);
        map.put(LOCATION_44, WALL);
        map.put(LOCATION_45, SPACE);
        map.put(LOCATION_46, WALL);


        map.put(LOCATION_50, WALL);
        map.put(LOCATION_51, START);
        map.put(LOCATION_52, SPACE);
        map.put(LOCATION_53, SPACE);
        map.put(LOCATION_54, WALL);
        map.put(LOCATION_55, SPACE);
        map.put(LOCATION_56, WALL);

        map.put(LOCATION_60, WALL);
        map.put(LOCATION_61, WALL);
        map.put(LOCATION_62, WALL);
        map.put(LOCATION_63, WALL);
        map.put(LOCATION_64, WALL);
        map.put(LOCATION_65, WALL);
        map.put(LOCATION_66, WALL);

        return new Maze(map);
    }

    public Maze given() {
        return unresolved;
    }

    public Maze expect() {
        return solved;
    }
}
