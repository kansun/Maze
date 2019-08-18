package service.build;

import model.Maze;

public interface MazeBuilder {

    Maze build(char[][] input);
}
