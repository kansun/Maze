package maze.service.solution.impl;

import maze.model.Direction;
import maze.model.Location;
import maze.model.Maze;
import maze.model.Square;
import maze.service.solution.Solutionizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class DFSSolutionizerImpl implements Solutionizer {

    @Override
    public Collection<Location> solve(Maze maze) {
        Deque<Location> path = new LinkedList<>();
        Collection<Location> visitedHistory = new ArrayList<>();

        if (isSolvable(maze, maze.getStart(), path, visitedHistory)) {
            return path;
        }
        return path;
    }

    private boolean isSolvable(Maze maze, Location start, Deque<Location> path, Collection<Location> visitedHistory) {
        Square current = maze.locateSquare(start);
        if (null == current || current == Square.WALL || visitedHistory.contains(start)) {
            return false;
        }
        path.push(start);
        visitedHistory.add(start);
        if (current == Square.END) {
            return true;
        }
        for (Direction direction : Direction.values()) {
            Location neighbour = start.locateNeighbour(direction);
            if (isSolvable(maze, neighbour, path, visitedHistory)) {
                return true;
            }
        }
        path.pop();
        return false;
    }
}
