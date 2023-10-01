package com.sinam.mybank.model.requests;

public class TransferRequestDTO {
    private String sender_account_code;
    private String receiver_account_code;
    private Long bankAccountId;
    private double amount;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSender_account_code() {
        return sender_account_code;
    }

    public void setSender_account_code(String sender_account_code) {
        this.sender_account_code = sender_account_code;
    }

    public String getReceiver_account_code() {
        return receiver_account_code;
    }

    public void setReceiver_account_code(String receiver_account_code) {
        this.receiver_account_code = receiver_account_code;
    }

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
