package service.solution.impl;

import model.Location;
import model.Maze;
import service.solution.MazeSolver;
import service.solution.SolutionApplier;
import service.solution.Solutionizer;

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
