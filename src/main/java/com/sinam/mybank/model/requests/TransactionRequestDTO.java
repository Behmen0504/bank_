package com.sinam.mybank.model.requests;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    @DecimalMin(value = "0.0", message = "Amount should not be less than 0.0")
    private BigDecimal amount;

    @NotBlank(message = "Sender Account Id is required")
    @Positive(message = "Sender Account Id should be a positive number")
    private Long senderAccountId;

    @NotBlank(message = "Receiver Account Id is required")
    @Positive(message = "Receiver Account Id should be a positive number")
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
