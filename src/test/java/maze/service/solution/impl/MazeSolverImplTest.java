package maze.service.solution.impl;

import maze.model.Maze;
import maze.service.solution.MazeSolver;
import org.junit.Before;
import org.junit.Test;

import static maze.util.TestResourcePool.COMPLEX_ROW_MAZE;
import static maze.util.TestResourcePool.DIAGONAL_MAZE_2;
import static maze.util.TestResourcePool.SINGLE_ROW_MAZE_0;
import static maze.util.TestResourcePool.SINGLE_ROW_MAZE_1;
import static maze.util.TestResourcePool.SINGLE_ROW_MAZE_2;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MazeSolverImplTest {

    private MazeSolver target;

    @Before
    public void setUp() {
        target = new MazeSolverImpl(new BFSSolutionizerImpl(), new SolutionApplierImpl());
    }

    @Test
    public void testSolveSingleRowMaze_0() {
        //Given
        /*
         * A single row maze like
         * ####
         * #SE#
         * ####
         * */
        Maze input = SINGLE_ROW_MAZE_0.given();

        //When
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(SINGLE_ROW_MAZE_0.expect()));
    }

    @Test
    public void testSolveSingleRowMaze_1() {
        //Given
        /*
         * A single row maze like
         * #####
         * #S E#
         * #####
         * */
        Maze input = SINGLE_ROW_MAZE_1.given();

        //When
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(SINGLE_ROW_MAZE_1.expect()));
    }

    @Test
    public void testSolveSingleRowMaze_2() {
        //Given
        /*
         * A single row maze like
         * ######
         * #S  E#
         * ######
         * */
        Maze input = SINGLE_ROW_MAZE_2.given();

        //When
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(SINGLE_ROW_MAZE_2.expect()));
    }

    @Test
    public void testSolveDiagonalMaze_1() {
        //Given
        /*
         * A single row maze like
         * ####
         * # E#
         * #S##
         * ####
         * */
        Maze input = DIAGONAL_MAZE_2.given();

        //When
        Maze actual = target.solve(input);

        //Then
        assertThat(actual, equalTo(DIAGONAL_MAZE_2.expect()));
    }

    @Test
    public void testSolveComplexMaze() {
        //Given
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
        Maze input = COMPLEX_ROW_MAZE.given();

        //When
        Maze actual = target.solve(input);

        //Then
        Maze expected = COMPLEX_ROW_MAZE.expect();
        assertThat(actual, equalTo(expected));
    }

}