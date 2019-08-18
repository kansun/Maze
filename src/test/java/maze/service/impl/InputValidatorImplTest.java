package maze.service.impl;

import maze.exception.DataValidationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import maze.service.InputValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static maze.exception.ApplicationException.MESSAGE_ILLEGAL_CHARS_TEMPLATE;
import static maze.exception.ApplicationException.MESSAGE_INCONSISTENT_WIDTHS;
import static org.hamcrest.Matchers.endsWith;
import static maze.util.TestConstants.TEST_RESOURCES_INPUT;

public class InputValidatorImplTest {

    @Rule
    public ExpectedException exceptionAssert = ExpectedException.none();
    private InputValidator target;

    @Before
    public void setUp() {
        target = new InputValidatorImpl();
    }

    @Test
    public void shouldThrowDataValidationExceptionWhenRowWithOddWidthRowDetected() throws IOException {
        exceptionAssert.expect(DataValidationException.class);
        exceptionAssert.expectMessage(endsWith(MESSAGE_INCONSISTENT_WIDTHS));
        //Given
        List<String> given = loadTestResource("INCONSISTENT_ROWS.txt");

        //When
        target.validate(given);
    }

    @Test
    public void shouldThrowFailFastWhenIllegalCharsDetected() throws IOException {
        exceptionAssert.expect(DataValidationException.class);
        exceptionAssert.expectMessage(endsWith(String.format(MESSAGE_ILLEGAL_CHARS_TEMPLATE, "'@', '@'")));
        //Given
        List<String> given = loadTestResource("ILLEGAL_CHARS.txt");

        //When
        target.validate(given);
    }

    @Test
    public void shouldFailFastWhenMixedErrorsDetected() throws IOException {
        exceptionAssert.expect(DataValidationException.class);
        exceptionAssert.expectMessage(endsWith(String.format(MESSAGE_ILLEGAL_CHARS_TEMPLATE, "'@'")));
        //Given
        List<String> given = loadTestResource("MIXED_ERRORS.txt");

        //When
        target.validate(given);
    }

    private List<String> loadTestResource(final String fileName) throws IOException {
        Path file = Paths.get(TEST_RESOURCES_INPUT + fileName);
        List<String> lines = Files.readAllLines(file);
        return lines;
    }
}