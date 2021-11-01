package com.sahaj.tigercard.exception;

public class InvalidDateTimeException extends Exception{
    public InvalidDateTimeException() {
        super();
    }

    public InvalidDateTimeException(String message) {
        super(message);
    }

    public InvalidDateTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
