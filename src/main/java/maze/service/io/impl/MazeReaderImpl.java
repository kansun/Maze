package maze.service.io.impl;

import maze.exception.FileReaderException;
import maze.service.InputValidator;
import maze.service.io.MazeReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;


public class MazeReaderImpl implements MazeReader {

    private final InputValidator validator;

    public MazeReaderImpl(InputValidator validator) {
        this.validator = validator;
    }

    @Override
    public char[][] read(Path file) {
        try {
            List<String> lines = Files.readAllLines(file);
            validator.validate(lines);
            char[][] output = new char[lines.size()][];
            for (int row = 0; row < lines.size(); row++) {
                String line = lines.get(row);
                char[] lineChars = line.toCharArray();
                output[row] = lineChars;
            }
            return output;
        } catch (IOException e) {
            UUID errorId = UUID.randomUUID();
            String message = "An I/O error has been encountered when reading the maze from the input file. ";
            throw new FileReaderException(errorId, message, e);
        }
    }
}
