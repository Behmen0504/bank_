package com.sinam.mybank.dao.repository;

import com.sinam.mybank.dao.entity.TransactionEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query("SELECT t FROM TransactionEntity t JOIN BankAccountEntity b ON b.id = t.senderAccountEntity.id or b.id = t.receiverAccountEntity.id JOIN UserEntity u ON b.userEntity.id = u.id where u.id=:userId")
    List<TransactionEntity> findAllByUserId(Long userId);

    @Query("SELECT t FROM TransactionEntity t JOIN BankAccountEntity b ON b.id = t.senderAccountEntity.id JOIN UserEntity u ON b.userEntity.id = u.id where u.id = :userId ")
    List<TransactionEntity> findTransactionsByUserId(Long userId);

    List<TransactionEntity> findAll(Specification<TransactionEntity> spec);
}
