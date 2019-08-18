package service.impl;

import model.ApplicationError;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import service.ApplicationErrorHandler;
import service.InputValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static service.ApplicationErrorHandler.MESSAGE_ILLEGAL_CHARS;
import static service.ApplicationErrorHandler.MESSAGE_INCONSISTENT_WIDTH;
import static util.TestConstants.TEST_RESOURCES_INPUT;

public class InputValidatorImplTest {

    @Rule
    public ExpectedException exceptionAssert = ExpectedException.none();
    private ErrorHandlerStub errorHandlerStub;
    private InputValidator target;

    @Before
    public void setUp() {
        target = new InputValidatorImpl(errorHandlerStub = new ErrorHandlerStub());
    }

    @Test
    public void shouldDelegateToErrorHandlerWhenRowWithOddWidthRowDetected() throws IOException {

        //Given
        List<String> given = loadTestResource("INCONSISTENT_ROWS.txt");

        //When
        target.validate(given);

        //Then
        assertThat(errorHandlerStub.getErrorsForAssertion(), containsInAnyOrder(new ApplicationError(MESSAGE_INCONSISTENT_WIDTH)));
    }

    @Test
    public void shouldDelegateToErrorHandlerWhenIllegalCharsDetected() throws IOException {

        //Given
        List<String> given = loadTestResource("ILLEGAL_CHARS.txt");

        //When
        target.validate(given);

        //Then
        assertThat(errorHandlerStub.getErrorsForAssertion(), containsInAnyOrder(new ApplicationError(MESSAGE_ILLEGAL_CHARS)));
    }

    @Test
    public void shouldDelegateToErrorHandlerWhenMixedErrorsDetected() throws IOException {

        //Given
        List<String> given = loadTestResource("MIXED_ERRORS.txt");

        //When
        target.validate(given);

        //Then
        assertThat(errorHandlerStub.getErrorsForAssertion(), containsInAnyOrder(
                new ApplicationError(MESSAGE_ILLEGAL_CHARS),
                new ApplicationError(MESSAGE_INCONSISTENT_WIDTH)
        ));
    }

    private List<String> loadTestResource(final String fileName) throws IOException {
        Path file = Paths.get(TEST_RESOURCES_INPUT + fileName);
        List<String> lines = Files.readAllLines(file);
        return lines;
    }

    static class ErrorHandlerStub implements ApplicationErrorHandler {

        private final Collection<ApplicationError> errorsForAssertion = new ArrayList<>();

        @Override
        public void handleErrors(Collection<ApplicationError> errors) {
            errorsForAssertion.addAll(errors);
        }

        public Collection<ApplicationError> getErrorsForAssertion() {
            return errorsForAssertion;
        }
    }
}