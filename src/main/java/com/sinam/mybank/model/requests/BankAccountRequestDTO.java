package com.sinam.mybank.model.requests;

import com.sinam.mybank.myenums.Status;

import java.math.BigDecimal;


public class BankAccountRequestDTO {
    private BigDecimal balance;
    private BigDecimal amount;
    private Status status;
    private Long userId = 1L;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
