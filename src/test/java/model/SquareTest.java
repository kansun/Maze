package model;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static model.SquareType.END;
import static model.SquareType.MARKED;
import static model.SquareType.SPACE;
import static model.SquareType.START;
import static model.SquareType.WALL;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class SquareTest {

    @Test
    public void shouldMarkSquareChangeTypeOnly() {
        //given
        Square unmarked = givenSquare(3, 4, SPACE);

        //when
        Square marked = mark(unmarked);

        //then
        assertThat(marked.getType(), equalTo(MARKED));
        assertThat(marked.isVisited(), equalTo(false));
        assertThat(marked.getLocation().getRow(), equalTo(unmarked.getLocation().getRow()));
        assertThat(marked.getLocation().getCol(), equalTo(unmarked.getLocation().getCol()));
    }

    @Test
    public void shouldVisitSquareChangeVisitedFlagOnly() {
        //given
        Square unvisited = givenSquare(3, 4, SPACE);

        //when
        Square visited = visit(unvisited);

        //then
        assertThat(visited.isVisited(), equalTo(true));
        assertThat(visited.getType(), equalTo(SPACE));
        assertThat(visited.getLocation().getRow(), equalTo(unvisited.getLocation().getRow()));
        assertThat(visited.getLocation().getCol(), equalTo(unvisited.getLocation().getCol()));
    }

    @Test
    public void testEquality() {
        //given
        Square wall1 = givenSquare(0, 0, WALL);
        Square wall2 = givenSquare(0, 1, WALL);
        Square cell1 = givenSquare(1, 1, SPACE);
        Square cell2 = givenSquare(1, 2, SPACE);
        Square start = givenSquare(2, 2, START);
        Square end = givenSquare(2, 2, END);
        Square duplicateEnd = givenSquare(2, 2, END);
        Collection<Square> withDuplidate = Arrays.asList(wall1, wall2, cell1, cell2, start, end, duplicateEnd);
        Collection<Square> withoutDuplicate = Arrays.asList(wall1, wall2, cell1, cell2, start, end);

        //when
        Set<Square> target = new HashSet<>(withDuplidate);

        //then
        assertThat(target, hasSize(withoutDuplicate.size()));
        assertThat(target, Matchers.containsInAnyOrder(withoutDuplicate.toArray()));
    }

    private Square givenSquare(int row, int col, SquareType type) {
        return Square.newBuilder().withCoordinate(new Location(row, col, null)).withType(type).withVisited(false).build();
    }

    private Square mark(Square unvisited) {
        return Square.newBuilder(unvisited).withType(MARKED).build();
    }

    private Square visit(Square visited) {
        return Square.newBuilder(visited).withVisited(true).build();
    }

}