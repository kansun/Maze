package service.solution.impl;

import model.Location;
import model.Maze;
import model.Square;
import org.junit.Test;
import service.solution.SolutionApplier;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static model.Square.END;
import static model.Square.SPACE;
import static model.Square.START;
import static model.Square.WALL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class SolutionApplierImplTest {

    private final SolutionApplier target = new SolutionApplierImpl();

    @Test
    public void shouldApplyWithoutChangingStartEndLabels() {
        //Given
        Location loc0 = new Location(1, 0);
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(1, 2);
        Location loc3 = new Location(1, 3);
        Location loc4 = new Location(1, 4);
        Location loc5 = new Location(1, 5);
        Map<Location, Square> source = new HashMap<Location, Square>() {{
            put(loc0, WALL);
            put(loc1, START);
            put(loc2, SPACE);
            put(loc3, SPACE);
            put(loc4, END);
            put(loc5, WALL);
        }};

        Collection<Location> solution = Arrays.asList(loc1, loc2, loc4);

        //When
        Map<Location, Square> actual = target.apply(new Maze(source, 1, 6), solution).getSquares();

        //Then
        assertThat(actual.get(loc0), equalTo(WALL));
        assertThat(actual.get(loc1), equalTo(START));
        assertThat(actual.get(loc2), equalTo(Square.MARKED));
        assertThat(actual.get(loc3), equalTo(SPACE));
        assertThat(actual.get(loc4), equalTo(END));
        assertThat(actual.get(loc5), equalTo(WALL));
    }
}