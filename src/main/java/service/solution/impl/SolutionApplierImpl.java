package service.solution.impl;

import model.Location;
import model.Maze;
import model.Square;
import service.solution.SolutionApplier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static model.Square.MARKED;

public class SolutionApplierImpl implements SolutionApplier {

    @Override
    public Maze apply(Maze target, Collection<Location> solution) {
        Map<Location, Square> squares = new HashMap<>(target.getSquares());
        solution.forEach(move ->
                squares.replaceAll((k, v) -> {
                    if (k.equals(move)) {
                        if (k.equals(target.getStart()) || k.equals(target.getEnd())) {
                            return v;
                        }
                        return MARKED;
                    } else {
                        return v;
                    }
                }));
        return new Maze(squares, target.getWidth(), target.getHeight());
    }
}
