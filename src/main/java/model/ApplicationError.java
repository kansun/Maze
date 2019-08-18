package model;

import java.util.Objects;

public final class ApplicationError {

    private final String message;

    public ApplicationError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationError applicationError = (ApplicationError) o;
        return Objects.equals(getMessage(), applicationError.getMessage());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMessage());
    }
}
