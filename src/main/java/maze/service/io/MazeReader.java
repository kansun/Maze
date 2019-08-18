package maze.service.io;

import java.nio.file.Path;

public interface MazeReader {

    char[][] read(Path file);
}
