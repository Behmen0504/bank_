package com.sinam.mybank.model;

import com.sinam.mybank.myenums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private Long senderAccountId;
    private Long receiverAccountId;
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "id=" + id +
                ", amount=" + amount +
                ", senderAccountId=" + senderAccountId +
                ", receiverAccountId=" + receiverAccountId +
                ", createdAt=" + createdAt +
                '}';
    }

    public TransactionDTO() {

    }

    public TransactionDTO(Long id, BigDecimal amount, Long senderAccountId, Long receiverAccountId, LocalDateTime createdAt) {
        this.id = id;
        this.amount = amount;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
