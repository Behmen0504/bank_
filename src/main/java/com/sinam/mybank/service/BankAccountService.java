package com.sinam.mybank.service;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import com.sinam.mybank.dao.entity.UserEntity;
import com.sinam.mybank.dao.repository.BankAccountRepository;
import com.sinam.mybank.dao.repository.UserRepository;
import com.sinam.mybank.mapper.BankAccountMapper;
import com.sinam.mybank.mapper.UserMapper;
import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.exception.NotFoundException;
import com.sinam.mybank.model.requests.BankAccountRequestDTO;
import com.sinam.mybank.model.specifications.BankAccountSpecifications;
import com.sinam.mybank.myenums.Status;
import com.sinam.mybank.service.auth.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccountDTO> getBankAccounts(Long bankAccountId, String pin) {
        Specification<BankAccountEntity> spec = Specification.where(BankAccountSpecifications.hasId(bankAccountId))
                .and(BankAccountSpecifications.hasUserFin(pin));

        return BankAccountMapper.INSTANCE.mapEntitiesToDtos(bankAccountRepository.findAll(spec));
    }

    public BankAccountDTO getBankAccount(Long id) {
        return BankAccountMapper.INSTANCE.mapEntityToDto(bankAccountRepository.findById(id).orElseThrow(
                () -> new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        ));
    }

    public List<BankAccountDTO> getUserActiveBankAccounts(String fin) {
        return UserMapper.INSTANCE.mapEntitiesToDtos(bankAccountRepository.findAllByUserEntity_FinAndStatus(fin, Status.ACTIVE));
    }

    public List<BankAccountDTO> getUserBankAccounts() {
        return BankAccountMapper.INSTANCE.mapEntitiesToDtos(bankAccountRepository.findAllByUserEntity_Id(AuthService.getUser().getId()));
    }

    public BankAccountDTO getUserBankAccountByBankAccountId(Long id) {
        var bankAccountEntity = getBankAccountIfExists(id);
        return BankAccountMapper.INSTANCE.mapEntityToDto(bankAccountEntity);
    }

    public void addBankAccount() {
        var bankAccountEntity = BankAccountMapper.INSTANCE.buildBankAccount();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(AuthService.getUser().getId());
        bankAccountEntity.setUserEntity(userEntity);
        bankAccountRepository.save(bankAccountEntity);
    }

    @Transactional
    public void updateBankAccount(Long id, BankAccountRequestDTO bankAccountRequestDTO) {
        var bankAccount = bankAccountRepository.findByIdForTransfer(id).orElseThrow(
                () -> new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        );

        bankAccount.setId(id);
        bankAccount.setBalance(bankAccountRequestDTO.getBalance());

        bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccount(Long bankAccountId) {
        var bankAccountEntity = getBankAccountIfExists(bankAccountId);
        bankAccountEntity.setStatus(Status.DELETED);
        bankAccountRepository.save(bankAccountEntity);
    }

    public void activateBankAccount(Long bankAccountId) {
        var bankAccountEntity = getBankAccountIfExists(bankAccountId);
        bankAccountEntity.setStatus(Status.ACTIVE);
        bankAccountRepository.save(bankAccountEntity);

    }
    private BankAccountEntity getBankAccountIfExists(Long bankAccountId){
        Long userId = AuthService.getUser().getId();
        return bankAccountRepository.findByIdAndUserEntity_Id(bankAccountId, userId).orElseThrow(
                () -> new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        );
    }
}
