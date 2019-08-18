package maze.context;

import maze.service.GlobalExceptionHandler;
import maze.service.InputValidator;
import maze.service.build.MazeBuilder;
import maze.service.build.MazeLoader;
import maze.service.build.impl.MazeBuilderImpl;
import maze.service.build.impl.MazeLoaderImpl;
import maze.service.impl.ExceptionHandlerImpl;
import maze.service.impl.InputValidatorImpl;
import maze.service.io.MazeReader;
import maze.service.io.MazeWriter;
import maze.service.io.impl.MazeReaderImpl;
import maze.service.io.impl.MazeWriterImpl;
import maze.service.solution.MazeSolver;
import maze.service.solution.impl.MazeSolverImpl;
import maze.service.solution.impl.SolutionApplierImpl;
import maze.service.solution.impl.SolutionizerImpl;

public final class ApplicationContext {

    private final MazeLoader loader;
    private final MazeSolver solver;
    private final MazeWriter writer;
    private final GlobalExceptionHandler exceptionHandler;

    private static ApplicationContext instance;

    private ApplicationContext() {
        InputValidator validator = new InputValidatorImpl();
        MazeReader reader = new MazeReaderImpl(validator);
        MazeBuilder builder = new MazeBuilderImpl();
        exceptionHandler = new ExceptionHandlerImpl();
        loader = new MazeLoaderImpl(reader, builder);
        solver = new MazeSolverImpl(new SolutionizerImpl(), new SolutionApplierImpl());
        writer = new MazeWriterImpl();
    }

    public static ApplicationContext getInstance() {
        if (instance == null) {
            instance = new ApplicationContext();
        }
        return instance;
    }

    public static void destroy() {
        instance = null;
    }

    public MazeLoader getLoader() {
        return loader;
    }

    public MazeSolver getSolver() {
        return solver;
    }

    public MazeWriter getWriter() {
        return writer;
    }

    public GlobalExceptionHandler getExceptionHandler() {
        return exceptionHandler;
    }
}
