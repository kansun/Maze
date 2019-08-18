package maze.service.solution;

import maze.model.Location;
import maze.model.Maze;

import java.util.Collection;

public interface SolutionApplier {

    Maze apply(Maze target, Collection<Location> solution);
}
