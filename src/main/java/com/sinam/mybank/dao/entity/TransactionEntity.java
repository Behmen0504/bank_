package com.sinam.mybank.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", senderAccountEntity=" + senderAccountEntity.getId() +
                ", receiverAccountEntity=" + receiverAccountEntity.getId() +
                ", createdAt=" + createdAt +
                '}';
    }

    public TransactionEntity() {

    }

    public TransactionEntity(Long id, BigDecimal amount, BankAccountEntity senderAccountEntity, BankAccountEntity receiverAccountEntity, LocalDateTime createdAt) {
        this.id = id;
        this.amount = amount;
        this.senderAccountEntity = senderAccountEntity;
        this.receiverAccountEntity = receiverAccountEntity;
        this.createdAt = createdAt;
    }

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
