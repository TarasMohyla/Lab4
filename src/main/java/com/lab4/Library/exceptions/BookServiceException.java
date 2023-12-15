package com.lab4.Library.exceptions;

public class BookServiceException extends RuntimeException{

    public BookServiceException(final String message) {
        super(message);
    }
}
