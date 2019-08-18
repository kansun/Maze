package service.solution;

import model.Location;
import model.Maze;

import java.util.Collection;

public interface Solutionizer {

    Collection<Location> solve(Maze input);
}
