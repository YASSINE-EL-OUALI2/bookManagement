package com.yassine.test.springbootDemo.errorHandling.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.yassine.test.springbootDemo.errorHandling.GlobalNotFoundException;

public class InventoriesErrorResponse extends GlobalNotFoundException {
    public InventoriesErrorResponse() {

    }

    public InventoriesErrorResponse(HttpStatus status, String msg, LocalDateTime timestamp) {
        super(status, msg, timestamp);
    }
}
