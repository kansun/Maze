import context.ApplicationContext;
import model.Maze;
import service.MazeLoader;
import service.MazeSolver;
import service.MazeWriter;

import java.util.Scanner;

public class Main {

    static MazeLoader loader;
    static MazeSolver solver;
    static MazeWriter writer;

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
    }

    private static void start(String inputPath) {
        Maze input = loader.load(inputPath);
        System.out.println("The input is: ");
        writer.write(input);
        Maze solution = solver.solve(input);
        System.out.println("The solution is: ");
        writer.write(solution);
    }
}
