package com.ismav.ems.exception;

import com.ismav.ems.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefinedException {

    @ExceptionHandler(value = CustomException.class)
    private ResponseEntity<Error> exceptionNotFound(CustomException exception) {
        Error error = new Error("Resource Not Found", exception.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CustomConflictException.class)
    private ResponseEntity<Error> exceptionConflict(CustomConflictException ex) {
        Error error = new Error("Data Conflict", ex.getMessage(), HttpStatus.CONFLICT);
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = CustomBadRequestException.class)
    private ResponseEntity<Error> exceptionConflict(CustomBadRequestException ex) {
        Error error = new Error("Bad Request", ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
