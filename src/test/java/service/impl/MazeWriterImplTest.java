package service.impl;

import model.Maze;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.MazeWriter;
import util.TestResourcePool;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MazeWriterImplTest {

    private final ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
    private MazeWriter target = new MazeWriterImpl();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(testOutput));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void shouldWriteMazeInto2DArray() {
        //Given
        Maze given = TestResourcePool.COMPLEX_ROW_MAZE.given();

        //When
        target.write(given);

        //Then
        String expected =
                "#######\n" +
                "#     #\n" +
                "# # # #\n" +
                "# #E# #\n" +
                "# ### #\n" +
                "#S  # #\n" +
                "#######\n";
        assertThat(testOutput.toString(), equalTo(expected));

    }

}