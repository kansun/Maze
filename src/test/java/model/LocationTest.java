package model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LocationTest {

    @Test
    public void shouldLocateNorthernNeighbourByCoordinate() {
        //Given
        Location target = new Location(1, 1, null);
        //When
        Location actual = target.locateNeighbour(Direction.UP);

        //Then
        assertThat(actual, equalTo(new Location(0, 1, target)));
    }

    @Test
    public void shouldLocateEasternNeighbourByCoordinate() {
        //Given
        Location target = new Location(1, 1, null);

        //When
        Location actual = target.locateNeighbour(Direction.RIGHT);

        //Then
        assertThat(actual, equalTo(new Location(1, 2, target)));
    }

    @Test
    public void shouldLocateSouthernNeighbourByCoordinate() {
        //Given
        Location target = new Location(1, 1, null);

        //When
        Location actual = target.locateNeighbour(Direction.DOWN);

        //Then
        assertThat(actual, equalTo(new Location(2, 1, target)));
    }

    @Test
    public void shouldLocateWesternNeighbourByCoordinate() {
        //Given
        Location target = new Location(1, 1, null);

        //When
        Location actual = target.locateNeighbour(Direction.LEFT);

        //Then
        assertThat(actual, equalTo(new Location(1, 0, target)));
    }
}