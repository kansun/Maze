package service.impl;

import model.Location;
import model.Maze;
import model.Square;
import service.SolutionApplier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static model.SquareType.MARKED;

public class SolutionApplierImpl implements SolutionApplier {

    @Override
    public Maze apply(Maze target, Collection<Location> solution) {
        Map<Location, Square> squares = new HashMap<>(target.getSquares());
        solution.forEach(move ->
                squares.replaceAll((k, v) -> {
                    if (k.equals(move)) {
                        if (k.equals(target.getStart().getLocation())) {
                            return target.getStart();
                        }
                        if (k.equals(target.getEnd().getLocation())) {
                            return target.getEnd();
                        }
                        return Square.newBuilder().withLocation(k).withType(MARKED).build();
                    } else {
                        return v;
                    }
                }));
        return new Maze(squares);
    }
}
