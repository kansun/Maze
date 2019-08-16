package service;

import model.Maze;

import java.io.File;

public interface MazeFileReader {

    Maze read(File file);
}
