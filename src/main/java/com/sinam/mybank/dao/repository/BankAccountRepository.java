package com.sinam.mybank.dao.repository;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity,Long> {

}
