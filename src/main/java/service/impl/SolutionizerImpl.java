package service.impl;

import model.Direction;
import model.Location;
import model.Maze;
import model.SquareType;
import service.Solutionizer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static model.SquareType.WALL;

public class SolutionizerImpl implements Solutionizer {

    @Override
    public Collection<Location> solve(Maze input) {
        Set<Location> visitHistory = new HashSet<>();
        Queue<Location> visitPlan = new LinkedList<>();
        visitPlan.offer(input.getStart().getLocation());
        Location endLocation = input.getEnd().getLocation();

        while (!visitPlan.isEmpty()) {
            Location current = visitPlan.poll();
            SquareType currentType = input.locateSquare(current).getType();

            if (WALL == currentType || visitHistory.contains(current)) {
                continue;
            }

            if (endLocation.equals(current)) {
                return trackPath(current);
            }

            visitHistory.add(current);
            for (Direction direction : Direction.values()) {
                Location neighbourLocation = current.locateNeighbour(direction);
                if (WALL != input.locateSquare(neighbourLocation).getType() && !visitHistory.contains(neighbourLocation)) {
                    visitPlan.offer(neighbourLocation);
                }
            }
        }
        return Collections.emptySet();
    }

    private Collection<Location> trackPath(Location current) {
        Set<Location> paths = new HashSet<>();
        while (current != null) {
            paths.add(current);
            current = current.getPrevious();
        }
        return paths;
    }
}
