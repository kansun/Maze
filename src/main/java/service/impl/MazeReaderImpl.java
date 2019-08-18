package service.impl;

import exception.FileReaderException;
import service.InputValidator;
import service.MazeReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


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
            throw new FileReaderException(e);
        }
    }
}
