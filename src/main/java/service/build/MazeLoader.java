package service.build;

import model.Maze;

public interface MazeLoader {

    Maze load(String inputFile);
}
