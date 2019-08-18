package maze.model;

import org.junit.Test;

import static maze.model.Square.END;
import static maze.model.Square.MARKED;
import static maze.model.Square.SPACE;
import static maze.model.Square.START;
import static maze.model.Square.WALL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SquareTest {

    private static final char WALL_CHAR = '#';
    private static final char SPACE_CHAR = ' ';
    private static final char START_CHAR = 'S';
    private static final char END_CHAR = 'E';
    private static final char MARKED_CHAR = '.';

    @Test
    public void shouldWallCarryLabel_Hash() {
        assertThat(WALL.getLabel(), equalTo(WALL_CHAR));
    }

    @Test
    public void shouldSpaceCarryLabel_Space() {
        assertThat(SPACE.getLabel(), equalTo(SPACE_CHAR));
    }

    @Test
    public void shouldStartCarryLabel_S() {
        assertThat(START.getLabel(), equalTo(START_CHAR));
    }

    @Test
    public void shouldEndCarryLabel_E() {
        assertThat(END.getLabel(), equalTo(END_CHAR));
    }

    @Test
    public void shouldMarkedCarryLabel_Dot() {
        assertThat(MARKED.getLabel(), equalTo(MARKED_CHAR));
    }

    @Test
    public void shouldCreateWallFromLabel_Hash() {
        Square actual = Square.fromLabel(WALL_CHAR);
        assertThat(actual, equalTo(WALL));
    }

    @Test
    public void shouldCreateStartFromLabel_S() {
        Square actual = Square.fromLabel(START_CHAR);
        assertThat(actual, equalTo(START));
    }

    @Test
    public void shouldCreateEndFromLabel_E() {
        Square actual = Square.fromLabel(END_CHAR);
        assertThat(actual, equalTo(END));
    }

    @Test
    public void shouldCreateSpaceFromLabel_Space() {
        Square actual = Square.fromLabel(SPACE_CHAR);
        assertThat(actual, equalTo(SPACE));
    }

    @Test
    public void shouldCreateMarkedFromLabel_Space() {
        Square actual = Square.fromLabel(MARKED_CHAR);
        assertThat(actual, equalTo(MARKED));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnUnknownChar() {
        Square.fromLabel('a');
    }


}