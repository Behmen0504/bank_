package com.sinam.mybank.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sinam.mybank.myenums.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "senderAccountEntity")
    private List<TransactionEntity> senderTransactionEntities;

    @JsonManagedReference
    @OneToMany(cascade = {CascadeType.MERGE}, mappedBy = "receiverAccountEntity")
    private List<TransactionEntity> receiverTransactionEntities;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public BankAccountEntity() {

    }

    @Override
    public String toString() {
        return "BankAccountEntity{" +
                "id=" + id +
                ", balance=" + balance +
                ", status=" + status +
                ", userEntity=" + userEntity +
                ", senderTransactionEntities=" + senderTransactionEntities +
                ", receiverTransactionEntities=" + receiverTransactionEntities +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public BankAccountEntity(Long id, BigDecimal balance, Status status, UserEntity userEntity, List<TransactionEntity> senderTransactionEntities, List<TransactionEntity> receiverTransactionEntities, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.status = status;
        this.userEntity = userEntity;
        this.senderTransactionEntities = senderTransactionEntities;
        this.receiverTransactionEntities = receiverTransactionEntities;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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
