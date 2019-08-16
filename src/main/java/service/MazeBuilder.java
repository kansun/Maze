package service;

import model.Maze;

public interface MazeBuilder {

    Maze build(char[][] input);
}
