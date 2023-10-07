package com.sinam.mybank.model.exception;

public class TransactionException extends RuntimeException{
    public TransactionException(String msg) {
        super(msg);
    }
}
