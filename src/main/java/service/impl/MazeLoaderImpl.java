package service.impl;

import model.Maze;
import service.MazeBuilder;
import service.MazeLoader;
import service.MazeReader;

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
