package maze;

import maze.context.ApplicationContext;
import maze.exception.ApplicationException;
import maze.model.Maze;
import maze.service.GlobalExceptionHandler;
import maze.service.build.MazeLoader;
import maze.service.io.MazeWriter;
import maze.service.solution.MazeSolver;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static MazeLoader loader;
    private static MazeSolver solver;
    private static MazeWriter writer;
    private static GlobalExceptionHandler exceptionHandler;

    public static void main(String[] args) {
        initialize();
        String inputPath = null;
        if (args.length == 0) {
            while (inputPath == null || inputPath.isEmpty()) {
                System.out.println("Please provide the absolute path to the maze input file: ");
                Scanner in = new Scanner(System.in);
                inputPath = in.nextLine();
            }
        } else {
            inputPath = args[0];
        }
        start(inputPath);
    }

    private static void initialize() {
        ApplicationContext context = ApplicationContext.getInstance();
        loader = context.getLoader();
        solver = context.getSolver();
        writer = context.getWriter();
        exceptionHandler = context.getExceptionHandler();
    }

    private static void start(String inputPath) {
        try {
            Maze input = loader.load(inputPath);
            System.out.println("The input is: ");
            writer.write(input);
            System.out.println("----------------------------------------------");
            Maze solution = solver.solve(input);
            System.out.println("The solution is: ");
            writer.write(solution);
        } catch (ApplicationException e) {
            exceptionHandler.handle(Arrays.asList(e));
        }
    }
}
