package com.lab4.Library.exceptions;

public class AuthorServiceException extends RuntimeException {

    public AuthorServiceException(final String message) {
        super(message);
    }
}
