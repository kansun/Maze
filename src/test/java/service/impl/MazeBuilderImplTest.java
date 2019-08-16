package service.impl;

import model.Maze;
import org.junit.Before;
import org.junit.Test;
import service.MazeBuilder;
import util.TestUtils;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.TestUtils.*;
import static util.TestUtils.createExpectedSingleRowMaze;

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
        Maze expected = createExpectedSingleRowMaze();
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
        Maze expected = createExpectedMaze();
        assertThat(actual, equalTo(expected));
    }

}