package model;

import org.junit.Test;
import util.TestResourcePool;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class MazeTest {

    @Test
    public void shouldLocateSquareByCoordinate() {
        //Given
        Maze target = TestResourcePool.SINGLE_ROW_MAZE_2.getUnresolved();

        //When
        Location location = new Location(1, 1, null);
        Square actual = target.locateSquare(location);

        //Then
        assertThat(actual.getLocation(), equalTo(location));
    }

    @Test
    public void shouldReturnNullWhenCannotLocateSquare() {
        //Given
        Maze target = TestResourcePool.SINGLE_ROW_MAZE_2.getUnresolved();

        //When
        Location location = new Location(999, 999, null);
        Square actual = target.locateSquare(location);

        //Then
        assertThat(actual, nullValue());
    }
}