package com.sinam.mybank.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sinam.mybank.myenums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "sender_account_id")
    private BankAccountEntity senderAccountEntity;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "receiver_account_id")
    private BankAccountEntity receiverAccountEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BankAccountEntity getSenderAccountEntity() {
        return senderAccountEntity;
    }

    public void setSenderAccountEntity(BankAccountEntity senderAccountEntity) {
        this.senderAccountEntity = senderAccountEntity;
    }

    public BankAccountEntity getReceiverAccountEntity() {
        return receiverAccountEntity;
    }

    public void setReceiverAccountEntity(BankAccountEntity receiverAccountEntity) {
        this.receiverAccountEntity = receiverAccountEntity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
