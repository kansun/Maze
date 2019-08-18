package context;

import service.GlobalExceptionHandler;
import service.InputValidator;
import service.build.MazeBuilder;
import service.build.MazeLoader;
import service.build.impl.MazeBuilderImpl;
import service.build.impl.MazeLoaderImpl;
import service.impl.ExceptionHandlerImpl;
import service.impl.InputValidatorImpl;
import service.io.MazeReader;
import service.io.MazeWriter;
import service.io.impl.MazeReaderImpl;
import service.io.impl.MazeWriterImpl;
import service.solution.MazeSolver;
import service.solution.impl.MazeSolverImpl;
import service.solution.impl.SolutionApplierImpl;
import service.solution.impl.SolutionizerImpl;

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
