package com.sinam.mybank.controller;

import com.sinam.mybank.model.TransactionDTO;
import com.sinam.mybank.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TransactionDTO> getTransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO getTransaction(@PathVariable Long id){
        return transactionService.getTransaction(id);
    }

}
