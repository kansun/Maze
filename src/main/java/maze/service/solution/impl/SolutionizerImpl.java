package maze.service.solution.impl;

import maze.model.Direction;
import maze.model.Location;
import maze.model.Maze;
import maze.model.Square;
import maze.service.solution.Solutionizer;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static maze.model.Square.WALL;

public class SolutionizerImpl implements Solutionizer {

    @Override
    public Collection<Location> solve(Maze input) {
        Set<Location> visitHistory = new HashSet<>();
        Queue<Location> visitPlan = new LinkedList<>();
        visitPlan.offer(input.getStart());
        Location endLocation = input.getEnd();

        while (!visitPlan.isEmpty()) {
            Location current = visitPlan.poll();
            Square currentType = input.locateSquare(current);

            if (WALL == currentType || visitHistory.contains(current)) {
                continue;
            }

            if (endLocation.equals(current)) {
                return trackPath(current);
            }

            visitHistory.add(current);
            for (Direction direction : Direction.values()) {
                Location neighbourLocation = current.locateNeighbour(direction);
                if (WALL != input.locateSquare(neighbourLocation) && !visitHistory.contains(neighbourLocation)) {
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
