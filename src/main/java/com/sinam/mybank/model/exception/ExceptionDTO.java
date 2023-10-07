package com.sinam.mybank.model.exception;


public class ExceptionDTO {
    String code;

    public ExceptionDTO(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
