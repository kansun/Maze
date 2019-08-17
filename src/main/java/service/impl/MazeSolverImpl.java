package service.impl;

import model.Location;
import model.Maze;
import service.MazeSolver;
import service.SolutionApplier;
import service.Solutionizer;

import java.util.Collection;

public class MazeSolverImpl implements MazeSolver {

    private final Solutionizer solutionizer;
    private final SolutionApplier solutionApplier;

    public MazeSolverImpl(Solutionizer solutionizer, SolutionApplier solutionApplier) {
        this.solutionizer = solutionizer;
        this.solutionApplier = solutionApplier;
    }

    @Override
    public Maze solve(Maze target) {
        Collection<Location> moves = solutionizer.solve(target);
        return solutionApplier.apply(target, moves);
    }
}
