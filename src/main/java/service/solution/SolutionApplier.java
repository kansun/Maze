package service.solution;

import model.Location;
import model.Maze;

import java.util.Collection;

public interface SolutionApplier {

    Maze apply(Maze target, Collection<Location> solution);
}
