package com.sinam.mybank.model.requests;

import com.sinam.mybank.myenums.Status;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    private BigDecimal amount;
    private Status status = Status.DEACTIVE;
    private Long senderAccountId;
    private Long receiverAccountId;

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
}
