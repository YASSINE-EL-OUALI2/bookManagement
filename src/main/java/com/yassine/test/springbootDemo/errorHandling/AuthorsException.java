package com.yassine.test.springbootDemo.errorHandling;

public class AuthorsException extends RuntimeException {

    public AuthorsException(String msg) {
        super(msg);
    }

    public AuthorsException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public AuthorsException(Throwable cause) {
        super(cause);
    }
}
