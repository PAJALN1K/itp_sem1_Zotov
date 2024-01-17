package src.task3;

import java.io.FileNotFoundException;

public class CustomFileNotFoundException extends Exception {
    public CustomFileNotFoundException(String message) {
        super(message);
    }

    public CustomFileNotFoundException(FileNotFoundException e) {
        super(e.getMessage());
    }
}
