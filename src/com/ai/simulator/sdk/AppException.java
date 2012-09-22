package com.ai.simulator.sdk;

/**
 * Exception in some application's work
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:20 PM
 */
public class AppException extends Exception {

    public AppException() {
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
