package model;

/**
 * A custom exception thrown from any of the Connect Four classes if something
 * goes wrong.
 * 
 * @author Josh Ross
 */
public class ConnectFourException extends Exception {
    /**
     * Convenience constructor to create a new ConnectFourException
     * with an error message.
     *
     * @param message The error message associated with the exception.
     */
    public ConnectFourException(String message) {
        super(message);
    }
}
