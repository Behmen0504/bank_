package com.sinam.mybank.model.exception;

public class AccountIsNotClosedToUserException extends RuntimeException{
    public AccountIsNotClosedToUserException(String msg) {
        super(msg);
    }
}
