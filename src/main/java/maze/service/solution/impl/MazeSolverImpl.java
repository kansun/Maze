package maze.service.solution.impl;

import maze.model.Location;
import maze.model.Maze;
import maze.service.solution.SolutionApplier;
import maze.service.solution.Solutionizer;
import maze.service.solution.MazeSolver;

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
