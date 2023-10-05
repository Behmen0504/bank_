package com.sinam.mybank.model;

import com.sinam.mybank.myenums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BankAccountDTO {
    private Long id;

    private BigDecimal balance;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BankAccountDTO() {}

    public BankAccountDTO(Long id, BigDecimal balance, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
