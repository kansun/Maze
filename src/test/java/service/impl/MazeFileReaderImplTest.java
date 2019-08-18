package service.impl;

import exception.FileReaderException;
import model.Location;
import model.Square;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import service.MazeFileReader;
import util.TestResourcePool;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static model.Square.fromLabel;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;
import static util.TestConstants.TEST_RESOURCES_INPUT;

public class MazeFileReaderImplTest {

    private final MazeFileReader target = new MazeFileReaderImpl(lines -> {
    });

    @Rule
    public ExpectedException exceptionAssert = ExpectedException.none();


    @Test
    public void shouldReadValidFileToCharArray() {

        //Given
        Path given = loadTestResource("COMPLEX_ROW_MAZE.txt");

        //When
        char[][] actual = target.read(given);

        //Then
        Map<Location, Square> map = TestResourcePool.COMPLEX_ROW_MAZE.given().getSquares();
        assertThat(convert(actual), equalTo(map));
    }

    @Test
    public void shouldExpectFileReaderExceptionWhenIOExceptionHandled() {
        exceptionAssert.expect(FileReaderException.class);
        exceptionAssert.expectCause(isA(IOException.class));

        //Given
        Path given = loadTestResource("NotFound.txt");

        //When
        target.read(given);
    }

    private Path loadTestResource(final String fileName) {
        return Paths.get(TEST_RESOURCES_INPUT + fileName);
    }

    private Map<Location, Square> convert(char[][] input) {
        Map<Location, Square> output = new HashMap<>();
        for (int row = 0; row < input.length; row++) {
            for (int col = 0; col < input[row].length; col++) {
                char label = input[row][col];
                Location location = new Location(row, col);
                output.put(location, fromLabel(label));
            }
        }
        return output;
    }
}