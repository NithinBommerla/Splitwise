package dev.nithin.Splitwise.exception;

public class UserAlreadyExistsInGroupException extends RuntimeException {
    public UserAlreadyExistsInGroupException() {}

    public UserAlreadyExistsInGroupException(String message) {
        super(message);
    }
}
