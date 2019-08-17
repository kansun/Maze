package service.impl;

import model.Location;
import model.Direction;
import model.Maze;
import model.Square;
import service.MazeSolver;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static model.SquareType.MARKED;
import static model.SquareType.WALL;

public class MazeSolverImpl implements MazeSolver {

    @Override
    public Maze solve(Maze maze) {
        Collection<Location> moves = getSolution(maze);
        Map<Location, Square> squares = new HashMap<>(maze.getSquares());
        moves.forEach(move ->
                squares.replaceAll((k, v) -> {
                    if (k.equals(move)) {
                        if (k.equals(maze.getStart().getLocation())) {
                            return maze.getStart();
                        }
                        if (k.equals(maze.getEnd().getLocation())) {
                            return maze.getEnd();
                        }
                        return Square.newBuilder().withCoordinate(k).withType(MARKED).build();
                    } else {
                        return v;
                    }
                }));

        Maze solved = new Maze(squares);
        return solved;
    }

    private Collection<Location> getSolution(Maze maze) {
        Set<Location> visitHistory = new HashSet<>();
        Queue<Location> visitPlan = new LinkedList<>();
        visitPlan.offer(maze.getStart().getLocation());
        Location endLocation = maze.getEnd().getLocation();

        while (!visitPlan.isEmpty()) {
            Location current = visitPlan.poll();
            Square toVisit = maze.locateSquare(current);

            if (WALL == toVisit.getType() || visitHistory.contains(current)) {
                continue;
            }

            if (endLocation.equals(current)) {
                return trackPath(current);
            }

            visitHistory.add(current);
            for (Direction direction : Direction.values()) {
                Location neighbourLocation = current.locateNeighbour(direction);
                if (WALL != toVisit.getType() && !visitHistory.contains(neighbourLocation)) {
                    visitPlan.offer(neighbourLocation);
                }
            }
        }
        return Collections.emptySet();
    }

    private Collection<Location> trackPath(Location current) {
        Location previous;
        Set<Location> paths = new HashSet<>();
        while ((previous = current.getPrevious()) != null) {
            paths.add(previous);
            current = previous;
        }
        return paths;
    }
}
