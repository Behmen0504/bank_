package com.sinam.mybank.service;

import com.sinam.mybank.dao.repository.BankAccountRepository;
import com.sinam.mybank.mapper.BankAccountMapper;
import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.exception.NotFoundException;
import com.sinam.mybank.model.requests.BankAccountRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<BankAccountDTO> getBankAccounts() {
        return BankAccountMapper.INSTANCE.mapEntitiesToDtos(bankAccountRepository.findAll());
    }

    public BankAccountDTO getBankAccount(Long id) {
        return BankAccountMapper.INSTANCE.mapEntityToDto(bankAccountRepository.findById(id).orElseThrow(
                ()->new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        ));
    }

    @Transactional
    public void addBankAccount(BankAccountRequestDTO requestDTO) {

    }

    public void updateBankAccount(Long id, BankAccountRequestDTO userRequestDTO) {
    }

    public void deleteBankAccount(Long id) {
    }
}
