package maze.service.impl;

import maze.exception.DataValidationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import maze.service.GlobalExceptionHandler;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.UUID;

public class ErrorHandlerImplTest {

    private final ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
    private GlobalExceptionHandler target = new ExceptionHandlerImpl();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(testOutput));
    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldWriteErrorsToConsole() {
        //When
        target.handle(Arrays.asList(new DataValidationException(UUID.randomUUID(), "error message")));
    }

}