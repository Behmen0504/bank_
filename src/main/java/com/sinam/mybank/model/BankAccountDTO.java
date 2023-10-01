package com.sinam.mybank.model;

import com.sinam.mybank.dao.entity.TransactionEntity;
import com.sinam.mybank.myenums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BankAccountDTO {
    private Long id;

    private BigDecimal balance;
    private BigDecimal amount;
    private Status status;
    private List<TransactionEntity> senderTransactionEntities;
    private List<TransactionEntity> receiverTransactionEntities;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

    public List<TransactionEntity> getSenderTransactionEntities() {
        return senderTransactionEntities;
    }

    public void setSenderTransactionEntities(List<TransactionEntity> senderTransactionEntities) {
        this.senderTransactionEntities = senderTransactionEntities;
    }

    public List<TransactionEntity> getReceiverTransactionEntities() {
        return receiverTransactionEntities;
    }

    public void setReceiverTransactionEntities(List<TransactionEntity> receiverTransactionEntities) {
        this.receiverTransactionEntities = receiverTransactionEntities;
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
