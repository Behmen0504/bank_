package com.sinam.mybank.model.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException(String msg) {
        super(msg);
    }
}
