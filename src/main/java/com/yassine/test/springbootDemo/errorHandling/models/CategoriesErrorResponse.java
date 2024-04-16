package com.yassine.test.springbootDemo.errorHandling.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.yassine.test.springbootDemo.errorHandling.GlobalNotFoundException;

public class CategoriesErrorResponse extends GlobalNotFoundException {
    public CategoriesErrorResponse() {

    }

    public CategoriesErrorResponse(HttpStatus status, String msg, LocalDateTime timestamp) {
        super(status, msg, timestamp);
    }
}
