package com.yassine.test.springbootDemo.controllers;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yassine.test.springbootDemo.errorHandling.AuthorsException;
import com.yassine.test.springbootDemo.errorHandling.BooksException;
import com.yassine.test.springbootDemo.errorHandling.CategoriesException;
import com.yassine.test.springbootDemo.errorHandling.InventoriesException;
import com.yassine.test.springbootDemo.errorHandling.models.AuthorsErrorResponse;
import com.yassine.test.springbootDemo.errorHandling.models.BooksErrorResponse;
import com.yassine.test.springbootDemo.errorHandling.models.CategoriesErrorResponse;
import com.yassine.test.springbootDemo.errorHandling.models.InventoriesErrorResponse;

@ControllerAdvice
public class ControllerExceptionHandler {

    // Internal Server Error
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BooksErrorResponse> handleOtherException(Exception exception) {
        BooksErrorResponse customError = new BooksErrorResponse();

        customError.setMsg(exception.getMessage());
        customError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        customError.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(customError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Book Not Found
    @ExceptionHandler(BooksException.class)
    public ResponseEntity<BooksErrorResponse> bookHandleException(BooksException exception) {
        BooksErrorResponse customError = new BooksErrorResponse();

        customError.setMsg(exception.getMessage());
        customError.setStatus(HttpStatus.NOT_FOUND);
        customError.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);

    }

    // Author Not Found
    @ExceptionHandler(AuthorsException.class)
    public ResponseEntity<AuthorsErrorResponse> authorHandleException(AuthorsException exception) {
        AuthorsErrorResponse customError = new AuthorsErrorResponse();

        customError.setMsg(exception.getMessage());
        customError.setStatus(HttpStatus.NOT_FOUND);
        customError.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);

    }

    // Categories Not Found
    @ExceptionHandler(CategoriesException.class)
    public ResponseEntity<CategoriesErrorResponse> categoryHandleException(CategoriesException exception) {
        CategoriesErrorResponse customError = new CategoriesErrorResponse();

        customError.setMsg(exception.getMessage());
        customError.setStatus(HttpStatus.NOT_FOUND);
        customError.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);

    }

    // Inventories Not Found
    @ExceptionHandler(InventoriesException.class)
    public ResponseEntity<InventoriesErrorResponse> inventoryHandleException(InventoriesException exception) {
        InventoriesErrorResponse customError = new InventoriesErrorResponse();

        customError.setMsg(exception.getMessage());
        customError.setStatus(HttpStatus.NOT_FOUND);
        customError.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);

    }

}
