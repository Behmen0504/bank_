package com.sinam.mybank.controller.handler;

import com.sinam.mybank.model.exception.InvalidCredentialsException;
import com.sinam.mybank.model.exception.ExceptionDTO;
import com.sinam.mybank.model.exception.NotFoundException;
import com.sinam.mybank.model.exception.TransactionException;
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
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionDTO handleInvalidCredentialsException(InvalidCredentialsException e) {
        return new ExceptionDTO(e.getMessage());
    }

    @ExceptionHandler(TransactionException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidCredentialsException(TransactionException e) {
        HttpStatus status;
        if ("ACCOUNT_IS_NOT_CLOSED_TO_USER".equals(e.getMessage())) {
            status = HttpStatus.FORBIDDEN;
        } else if ("AMOUNT_GREATER_THAN_BALANCE".equals(e.getMessage())) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()),status);
    }

}

