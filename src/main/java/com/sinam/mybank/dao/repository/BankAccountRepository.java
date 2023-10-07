package com.sinam.mybank.dao.repository;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import com.sinam.mybank.myenums.Status;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long>, JpaSpecificationExecutor<BankAccountEntity> {
    Optional<BankAccountEntity> findByIdAndUserEntity_Id(Long id, Long userId);

    List<BankAccountEntity> findAllByUserEntity_Id(Long id);

    List<BankAccountEntity> findAllByUserEntity_FinAndStatus(String fin, Status status);

    List<BankAccountEntity> findAll(Specification<BankAccountEntity> spec);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT b FROM BankAccountEntity b WHERE b.id = :id and b.status='ACTIVE'")
    Optional<BankAccountEntity> findByIdForTransfer(Long id);
}
