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
import com.sinam.mybank.myenums.Status;
import com.sinam.mybank.service.auth.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final UserRepository userRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository, UserRepository userRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
    }

    public List<BankAccountDTO> getBankAccounts(Long bankAccountId, String pin) {
        return BankAccountMapper.INSTANCE.mapEntitiesToDtos(bankAccountRepository.findAllByIdAndUserEntity_Fin(bankAccountId, pin));
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
        long userId = AuthService.getUser().getId();
        return BankAccountMapper.INSTANCE.mapEntityToDto(bankAccountRepository.findByIdAndUserEntity_Id(id, userId).orElseThrow(
                () -> new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        ));
    }

    public void addBankAccount(BankAccountRequestDTO requestDTO) {
        BankAccountEntity bankAccountEntity = BankAccountMapper.INSTANCE.mapBankAccountRequestDtoToEntity(requestDTO);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(AuthService.getUser().getId());
        bankAccountEntity.setUserEntity(userEntity);
        bankAccountRepository.save(bankAccountEntity);
    }

    @Transactional
    public void updateBankAccount(Long id, BankAccountRequestDTO bankAccountRequestDTO) {
        var user = userRepository.findById(AuthService.getUser().getId()).orElseThrow(
                () -> new NotFoundException("USER_NOT_FOUND_EXCEPTION")
        );
        var bankAccount = bankAccountRepository.findByIdForTransfer(id).orElseThrow(
                () -> new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        );
        if (bankAccount == null) {
            throw new NotFoundException("BANK_ACCOUNT_NOT_FOUND");
        }

        bankAccount.setId(id);
        bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        bankAccount.setStatus(bankAccountRequestDTO.getStatus());

        bankAccountRepository.save(bankAccount);
    }

    public void deleteBankAccount(Long id) {
    }

    public void activateBankAccount(Long bankAccountId) {
        Long usId = AuthService.getUser().getId();
        BankAccountEntity bankAccountEntity = bankAccountRepository.findByIdAndUserEntity_Id(bankAccountId, usId).orElseThrow(
                () -> new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        );
        bankAccountEntity.setStatus(Status.ACTIVE);
        bankAccountRepository.save(bankAccountEntity);

    }
}
