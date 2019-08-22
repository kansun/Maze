package maze.service.solution.impl;

import maze.model.Location;
import maze.model.Maze;
import maze.model.Square;
import maze.service.solution.Solutionizer;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static maze.util.TestResourcePool.COMPLEX_ROW_MAZE;
import static maze.util.TestResourcePool.DIAGONAL_MAZE_2;
import static maze.util.TestResourcePool.SINGLE_ROW_MAZE_0;
import static maze.util.TestResourcePool.SINGLE_ROW_MAZE_1;
import static maze.util.TestResourcePool.SINGLE_ROW_MAZE_2;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class BFSSolutionizerImplTest {

    private static final Collection<Square> RESULT_TYPES = new HashSet<Square>() {{
        add(Square.MARKED);
        add(Square.START);
        add(Square.END);
    }};
    private Solutionizer target;

    @Before
    public void setUp() {
        target = new BFSSolutionizerImpl();
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
        Collection<Location> actual = target.solve(input);

        //Then
        List<Location> expects = getLocations(SINGLE_ROW_MAZE_0.expect().getSquares());
        assertThat(actual, containsInAnyOrder(expects.toArray()));
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
        Collection<Location> actual = target.solve(input);

        //Then
        List<Location> expects = getLocations(SINGLE_ROW_MAZE_1.expect().getSquares());
        assertThat(actual, containsInAnyOrder(expects.toArray()));
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
        Collection<Location> actual = target.solve(input);

        //Then
        List<Location> expects = getLocations(SINGLE_ROW_MAZE_2.expect().getSquares());
        assertThat(actual, containsInAnyOrder(expects.toArray()));
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
        Collection<Location> actual = target.solve(input);

        //Then
        List<Location> expects = getLocations(DIAGONAL_MAZE_2.expect().getSquares());
        assertThat(actual, containsInAnyOrder(expects.toArray()));
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
        Collection<Location> actual = target.solve(input);

        //Then
        List<Location> expects = getLocations(COMPLEX_ROW_MAZE.expect().getSquares());
        assertThat(actual, containsInAnyOrder(expects.toArray()));
    }

    private List<Location> getLocations(Map<Location, Square> squares) {
        return squares.entrySet().stream().filter(e -> RESULT_TYPES.contains(e.getValue())).map(Map.Entry::getKey).collect(toList());
    }

}
