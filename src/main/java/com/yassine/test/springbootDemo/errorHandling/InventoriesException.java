package com.yassine.test.springbootDemo.errorHandling;

public class InventoriesException extends RuntimeException {

    public InventoriesException(String msg) {
        super(msg);
    }

    public InventoriesException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InventoriesException(Throwable cause) {
        super(cause);
    }
    
}
