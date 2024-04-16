package com.yassine.test.springbootDemo.errorHandling.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.yassine.test.springbootDemo.errorHandling.GlobalNotFoundException;

public class AuthorsErrorResponse extends GlobalNotFoundException {
    
    public AuthorsErrorResponse(){

    }

    public AuthorsErrorResponse(HttpStatus status, String msg, LocalDateTime timestamp){
        super(status, msg, timestamp);
    }
}
