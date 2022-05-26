package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResultException.class)
    public ResponseEntity handleNoResultException(NoResultException ex) {
        return new ResponseEntity(ex.toString(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity handleIllegalStateException(IllegalStateException ex) {
        return new ResponseEntity(ex.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity handleEntityExistsException(EntityExistsException ex) {
        return new ResponseEntity(ex.toString(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity(ex.toString(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity(ex.toString(), HttpStatus.NO_CONTENT);
    }

}
