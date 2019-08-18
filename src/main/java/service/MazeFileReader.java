package service;

import java.nio.file.Path;

public interface MazeFileReader {

    char[][] read(Path file);
}
