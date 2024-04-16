package com.yassine.test.springbootDemo.errorHandling;

public class BooksException extends RuntimeException {

    public BooksException(String msg) {
        super(msg);
    }

    public BooksException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BooksException(Throwable cause) {
        super(cause);
    }

}
