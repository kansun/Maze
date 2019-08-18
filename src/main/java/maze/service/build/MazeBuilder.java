package maze.service.build;

import maze.model.Maze;

public interface MazeBuilder {

    Maze build(char[][] input);
}
