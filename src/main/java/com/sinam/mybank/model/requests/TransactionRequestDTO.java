package com.sinam.mybank.model.requests;

import com.sinam.mybank.myenums.Status;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    private BigDecimal amount;
    private Long senderAccountId;//uuid etmek
    private Long receiverAccountId;

    @Override
    public String toString() {
        return "TransactionRequestDTO{" +
                "amount=" + amount +
                ", senderAccountId=" + senderAccountId +
                ", receiverAccountId=" + receiverAccountId +
                '}';
    }

    public TransactionRequestDTO() {

    }

    public TransactionRequestDTO(BigDecimal amount, Long senderAccountId, Long receiverAccountId) {
        this.amount = amount;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
