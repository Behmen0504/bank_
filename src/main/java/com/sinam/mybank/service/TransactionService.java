package com.sinam.mybank.service;

import com.sinam.mybank.dao.repository.TransactionRepository;
import com.sinam.mybank.mapper.TransactionMapper;
import com.sinam.mybank.model.TransactionDTO;
import com.sinam.mybank.model.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<TransactionDTO> getTransactions() {
        return TransactionMapper.INSTANCE.mapEntitiesToDtos(transactionRepository.findAll());
    }

    public TransactionDTO getTransaction(Long id) {
        return TransactionMapper.INSTANCE.mapEntityToDto(transactionRepository.findById(id).orElseThrow(
                ()->new NotFoundException("TRANSACTION_NOT_FOUND")
        ));
    }
}
