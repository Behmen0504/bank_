package com.sinam.mybank.service;

import com.sinam.mybank.dao.entity.BankAccountEntity;
import com.sinam.mybank.dao.repository.BankAccountRepository;
import com.sinam.mybank.dao.repository.TransactionRepository;
import com.sinam.mybank.mapper.TransactionMapper;
import com.sinam.mybank.model.TransactionDTO;
import com.sinam.mybank.model.exception.AccountIsNotClosedToUserException;
import com.sinam.mybank.model.exception.AmountGreaterThanBalanceException;
import com.sinam.mybank.model.exception.NotFoundException;
import com.sinam.mybank.model.requests.TransactionRequestDTO;
import com.sinam.mybank.service.auth.AuthService;
import jakarta.transaction.Status;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final BankAccountRepository bankAccountRepository;

    public TransactionService(TransactionRepository transactionRepository, BankAccountRepository bankAccountRepository) {
        this.transactionRepository = transactionRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    public List<TransactionDTO> getTransactions(Long id, String fin, Long senderAccountId) {
        var transactions = transactionRepository.findTransactionsByCriteria(id, fin, senderAccountId);
        return TransactionMapper.INSTANCE.mapEntitiesToDtos(transactions);
    }

    public List<TransactionDTO> getAllTransactionsByUserId() {
        return TransactionMapper.INSTANCE.mapEntitiesToDtos(transactionRepository.findAllByUserId(AuthService.getUser().getId()));
    }
    public List<TransactionDTO> getTransactionsByUserId() {
        return TransactionMapper.INSTANCE.mapEntitiesToDtos(transactionRepository.findTransactionsByUserId(AuthService.getUser().getId()));
    }

    @Transactional
    public void addTransaction(TransactionRequestDTO transactionRequestDTO) {
        Long userId = AuthService.getUser().getId();
        BankAccountEntity senderBankAccountEntity = bankAccountRepository.findByIdForTransfer(transactionRequestDTO.getSenderAccountId()).orElseThrow(
                ()->new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        );

        if (userId != senderBankAccountEntity.getUserEntity().getId()){
            throw new AccountIsNotClosedToUserException("AccountIsNotClosedToUserException");
        }

        BankAccountEntity receiverrBankAccountEntity = bankAccountRepository.findByIdForTransfer(transactionRequestDTO.getReceiverAccountId()).orElseThrow(
                ()->new NotFoundException("BANK_ACCOUNT_NOT_FOUND")
        );

        if (!(senderBankAccountEntity.getBalance().compareTo(transactionRequestDTO.getAmount()) >= 0)) {
            throw new AmountGreaterThanBalanceException("AMOUNT_GREATER_THAN_BALANCE");
        }
        senderBankAccountEntity.setBalance(senderBankAccountEntity.getBalance().subtract(transactionRequestDTO.getAmount()));
        receiverrBankAccountEntity.setBalance(receiverrBankAccountEntity.getBalance().add(transactionRequestDTO.getAmount()));

        bankAccountRepository.save(senderBankAccountEntity);
        bankAccountRepository.save(receiverrBankAccountEntity);


        transactionRepository.save(TransactionMapper.INSTANCE.mapTransactionRequestDtoToEntity(transactionRequestDTO));
    }


}
