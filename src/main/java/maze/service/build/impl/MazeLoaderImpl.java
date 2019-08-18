package maze.service.build.impl;

import maze.model.Maze;
import maze.service.build.MazeLoader;
import maze.service.build.MazeBuilder;
import maze.service.io.MazeReader;

import java.nio.file.Paths;

public class MazeLoaderImpl implements MazeLoader {

    private final MazeReader reader;
    private final MazeBuilder builder;

    public MazeLoaderImpl(MazeReader reader, MazeBuilder builder) {
        this.reader = reader;
        this.builder = builder;
    }

    @Override
    public Maze load(String inputFile) {
        char[][] chars = reader.read(Paths.get(inputFile));
        Maze maze = builder.build(chars);
        return maze;
    }
}
