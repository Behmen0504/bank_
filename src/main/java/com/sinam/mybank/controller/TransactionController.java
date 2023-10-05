package com.sinam.mybank.controller;

import com.sinam.mybank.model.TransactionDTO;
import com.sinam.mybank.model.requests.TransactionRequestDTO;
import com.sinam.mybank.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("@permissionService.hasPermission({'ADMIN'})")
    public List<TransactionDTO> getTransactions(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "fin", required = false) String fin,
            @RequestParam(name = "senderAccountId", required = false) Long senderAccountId
    ) {
        return transactionService.getTransactions(id,fin,senderAccountId);
    }

    @GetMapping("/user-all-transactions")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@permissionService.hasPermission({'USER'})")
    public List<TransactionDTO> getAllTransactionsByUserId() {
        return transactionService.getAllTransactionsByUserId();
    }

    @GetMapping("/user-transactions")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@permissionService.hasPermission({'USER'})")
    public List<TransactionDTO> getTransactionsByUserId() {
        return transactionService.getTransactionsByUserId();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addTransaction(@RequestBody TransactionRequestDTO transactionRequestDTO) {
        transactionService.addTransaction(transactionRequestDTO);
    }
}
