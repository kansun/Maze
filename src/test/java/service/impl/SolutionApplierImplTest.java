package service.impl;

import model.Location;
import model.Maze;
import model.Square;
import model.SquareType;
import org.junit.Test;
import service.SolutionApplier;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
            put(loc0, Square.newBuilder().withLocation(loc0).withType(SquareType.WALL).build());
            put(loc1, Square.newBuilder().withLocation(loc1).withType(SquareType.START).build());
            put(loc2, Square.newBuilder().withLocation(loc2).withType(SquareType.SPACE).build());
            put(loc3, Square.newBuilder().withLocation(loc3).withType(SquareType.SPACE).build());
            put(loc4, Square.newBuilder().withLocation(loc4).withType(SquareType.END).build());
            put(loc5, Square.newBuilder().withLocation(loc5).withType(SquareType.WALL).build());
        }};

        Collection<Location> solution = Arrays.asList(loc1, loc2, loc4);

        //When
        Map<Location, Square> actual = target.apply(new Maze(source), solution).getSquares();

        //Then
        assertThat(actual.get(loc0).getType(), equalTo(SquareType.WALL));
        assertThat(actual.get(loc1).getType(), equalTo(SquareType.START));
        assertThat(actual.get(loc2).getType(), equalTo(SquareType.MARKED));
        assertThat(actual.get(loc3).getType(), equalTo(SquareType.SPACE));
        assertThat(actual.get(loc4).getType(), equalTo(SquareType.END));
        assertThat(actual.get(loc5).getType(), equalTo(SquareType.WALL));
    }


}