package com.sinam.mybank.model.requests;

import com.sinam.mybank.myenums.Status;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;


public class BankAccountRequestDTO {
    @DecimalMin(value = "0.0", message = "Balance should not be less than 0.0")
    private BigDecimal balance = BigDecimal.valueOf(300);
    private Status status = Status.DEACTIVE;

    @Override
    public String toString() {
        return "BankAccountRequestDTO{" +
                "balance=" + balance +
                ", status=" + status +
                '}';
    }

    public BankAccountRequestDTO() {

    }

    public BankAccountRequestDTO(BigDecimal balance, Status status) {
        this.balance = balance;
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
