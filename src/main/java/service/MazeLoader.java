package service;

import model.Maze;

public interface MazeLoader {

    Maze load(String inputFile);
}
