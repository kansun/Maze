package service;

import model.Maze;

import java.io.File;

public interface MazeFileWriter {

    File write(Maze maze);
}
