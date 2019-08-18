package maze.service.solution;

import maze.model.Location;
import maze.model.Maze;

import java.util.Collection;

public interface Solutionizer {

    Collection<Location> solve(Maze input);
}
