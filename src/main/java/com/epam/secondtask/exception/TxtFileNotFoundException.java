package java.com.epam.secondtask.exception;

public class TxtFileNotFoundException extends Exception {
    public TxtFileNotFoundException() {
    }

    public TxtFileNotFoundException(String message) {
        super(message);
    }

    public TxtFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TxtFileNotFoundException(Throwable cause) {
        super(cause);
    }
}
