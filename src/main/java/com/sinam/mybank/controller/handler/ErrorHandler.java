package com.sinam.mybank.controller.handler;

import com.sinam.mybank.model.exception.InvalidCredentialsException;
import com.sinam.mybank.model.exception.ExceptionDTO;
import com.sinam.mybank.model.exception.NotFoundException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDTO handle(NotFoundException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(e.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDTO handle(SQLException e) {
        return new ExceptionDTO(e.getMessage());
    }


    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ExceptionDTO handle(InvalidCredentialsException e) {
        return new ExceptionDTO(e.getMessage());
    }

}

