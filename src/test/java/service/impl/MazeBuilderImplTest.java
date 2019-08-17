package service.impl;

import model.Maze;
import org.junit.Before;
import org.junit.Test;
import service.MazeBuilder;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.TestResourcePool.COMPLEX_ROW_MAZE;
import static util.TestResourcePool.SINGLE_ROW_MAZE_2;

public class MazeBuilderImplTest {

    private MazeBuilder target;

    @Before
    public void setUp() {
        target = new MazeBuilderImpl();
    }

    @Test
    public void shouldBuildSingleRowMazeFrom2DArrayInput() {
        //given
        /*
         * A single row maze like
         * ######
         * #S  E#
         * ######
         * */
        char[][] input = new char[][]{
                {'#', '#', '#', '#', '#', '#'},
                {'#', 'S', ' ', ' ', 'E', '#'},
                {'#', '#', '#', '#', '#', '#'}
        };

        //when
        Maze actual = target.build(input);

        //then
        Maze expected = SINGLE_ROW_MAZE_2.getUnresolved();
        assertThat(actual, equalTo(expected));
    }

    @Test
    public void shouldBuildMazeFrom2DArrayInput() {
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
        char[][] input = new char[][]{
                {'#', '#', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', 'E', '#', ' ', '#'},
                {'#', ' ', '#', '#', '#', ' ', '#'},
                {'#', 'S', ' ', ' ', '#', ' ', '#'},
                {'#', '#', '#', '#', '#', '#', '#'}
        };

        //when
        Maze actual = target.build(input);

        //then
        Maze expected = COMPLEX_ROW_MAZE.getUnresolved();
        assertThat(actual, equalTo(expected));
    }

}