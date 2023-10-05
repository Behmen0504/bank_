package com.sinam.mybank.model.exception;

public class AmountGreaterThanBalanceException extends RuntimeException{
    public AmountGreaterThanBalanceException(String msg) {
        super(msg);
    }
}
