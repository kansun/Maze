package maze.service.build;

import maze.model.Maze;

public interface MazeLoader {

    Maze load(String inputFile);
}
