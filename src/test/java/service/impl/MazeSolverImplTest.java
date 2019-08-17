package service.impl;

import model.Maze;
import org.junit.Before;
import org.junit.Test;
import service.MazeSolver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.TestResourcePool.COMPLEX_ROW_MAZE;
import static util.TestResourcePool.DIAGONAL_MAZE_2;
import static util.TestResourcePool.SINGLE_ROW_MAZE_0;
import static util.TestResourcePool.SINGLE_ROW_MAZE_1;
import static util.TestResourcePool.SINGLE_ROW_MAZE_2;

public class MazeSolverImplTest {

    private MazeSolver target;

    @Before
    public void setUp() {
        target = new MazeSolverImpl(new SolutionizerImpl(), new SolutionApplierImpl());
    }

    @Test
    public void testSolveSingleRowMaze_0() {
        //given
        /*
         * A single row maze like
         * ####
         * #SE#
         * ####
         * */
        Maze input = SINGLE_ROW_MAZE_0.getUnresolved();

        //when
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(SINGLE_ROW_MAZE_0.getSolved()));
    }

    @Test
    public void testSolveSingleRowMaze_1() {
        //given
        /*
         * A single row maze like
         * #####
         * #S E#
         * #####
         * */
        Maze input = SINGLE_ROW_MAZE_1.getUnresolved();

        //when
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(SINGLE_ROW_MAZE_1.getSolved()));
    }

    @Test
    public void testSolveSingleRowMaze_2() {
        //given
        /*
         * A single row maze like
         * ######
         * #S  E#
         * ######
         * */
        Maze input = SINGLE_ROW_MAZE_2.getUnresolved();

        //when
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(SINGLE_ROW_MAZE_2.getSolved()));
    }

    @Test
    public void testSolveDiagonalMaze_1() {
        //given
        /*
         * A single row maze like
         * ####
         * # E#
         * #S##
         * ####
         * */
        Maze input = DIAGONAL_MAZE_2.getUnresolved();

        //when
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(DIAGONAL_MAZE_2.getSolved()));
    }

    @Test
    public void testSolveComplexMaze() {
        //given
        /*
         * A single row maze like
         * #######
         * #     #
         * # # # #
         * # #E# #
         * # ### #
         * #S  # #
         * #######
         * */
        Maze input = COMPLEX_ROW_MAZE.getUnresolved();

        //when
        Maze actual = target.solve(input);

        //Then
        Maze expected = COMPLEX_ROW_MAZE.getSolved();
        assertThat(actual, equalTo(expected));
    }

}