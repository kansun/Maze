package maze.model;

import org.junit.Test;
import maze.util.TestResourcePool;

import static maze.model.Square.START;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MazeTest {

    @Test
    public void shouldLocateSquareByCoordinate() {
        //Given
        Maze target = TestResourcePool.SINGLE_ROW_MAZE_2.given();

        //When
        Location location = new Location(1, 1);
        Square actual = target.locateSquare(location);

        //Then
        assertThat(actual, is(START));
    }

    @Test
    public void shouldReturnNullWhenCannotLocateSquare() {
        //Given
        Maze target = TestResourcePool.SINGLE_ROW_MAZE_2.given();

        //When
        Location location = new Location(999, 999);
        Square actual = target.locateSquare(location);

        //Then
        assertThat(actual, nullValue());
    }
}