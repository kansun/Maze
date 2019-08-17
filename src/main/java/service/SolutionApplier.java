package service;

import model.Location;
import model.Maze;

import java.util.Collection;

public interface SolutionApplier {

    Maze apply(Maze source, Collection<Location> solution);
}
