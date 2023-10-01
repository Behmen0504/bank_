package com.sinam.mybank.dao.repository;


import com.sinam.mybank.dao.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {

}
