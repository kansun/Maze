package context;

import service.GlobalExceptionHandler;
import service.InputValidator;
import service.MazeBuilder;
import service.MazeLoader;
import service.MazeReader;
import service.MazeSolver;
import service.MazeWriter;
import service.impl.ExceptionHandlerImpl;
import service.impl.InputValidatorImpl;
import service.impl.MazeBuilderImpl;
import service.impl.MazeLoaderImpl;
import service.impl.MazeReaderImpl;
import service.impl.MazeSolverImpl;
import service.impl.MazeWriterImpl;
import service.impl.SolutionApplierImpl;
import service.impl.SolutionizerImpl;

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
