package service;

import model.Location;
import model.Maze;

import java.util.Collection;

public interface Solutinizer {

    Collection<Location> getSolution(Maze input);
}
