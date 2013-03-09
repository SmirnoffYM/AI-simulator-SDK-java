package com.ai.simulator.sdk;

/**
 * Exception in some application's work
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:20 PM
 */
public class AppException extends Exception {

    @SuppressWarnings("unused")
    public AppException() {
    }

    @SuppressWarnings("unused")
    public AppException(String message) {
        super(message);
    }

    @SuppressWarnings("unused")
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    @SuppressWarnings("unused")
    public AppException(Throwable cause) {
        super(cause);
    }
}
