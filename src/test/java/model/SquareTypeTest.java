package model;

import org.junit.Test;

import static model.SquareType.END;
import static model.SquareType.START;
import static model.SquareType.SPACE;
import static model.SquareType.MARKED;
import static model.SquareType.WALL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SquareTypeTest {

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
        SquareType actual = SquareType.fromLabel(WALL_CHAR);
        assertThat(actual, equalTo(WALL));
    }

    @Test
    public void shouldCreateStartFromLabel_S() {
        SquareType actual = SquareType.fromLabel(START_CHAR);
        assertThat(actual, equalTo(START));
    }

    @Test
    public void shouldCreateEndFromLabel_E() {
        SquareType actual = SquareType.fromLabel(END_CHAR);
        assertThat(actual, equalTo(END));
    }

    @Test
    public void shouldCreateSpaceFromLabel_Space() {
        SquareType actual = SquareType.fromLabel(SPACE_CHAR);
        assertThat(actual, equalTo(SPACE));
    }

    @Test
    public void shouldCreateMarkedFromLabel_Space() {
        SquareType actual = SquareType.fromLabel(MARKED_CHAR);
        assertThat(actual, equalTo(MARKED));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionOnUnknownChar() {
        SquareType.fromLabel('a');
    }


}