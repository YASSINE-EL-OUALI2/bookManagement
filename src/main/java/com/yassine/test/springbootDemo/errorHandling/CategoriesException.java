package com.yassine.test.springbootDemo.errorHandling;

public class CategoriesException extends RuntimeException {

    public CategoriesException(String msg) {
        super(msg);
    }

    public CategoriesException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public CategoriesException(Throwable cause) {
        super(cause);
    }
}
