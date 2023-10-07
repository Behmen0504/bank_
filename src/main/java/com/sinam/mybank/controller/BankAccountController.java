package com.sinam.mybank.controller;

import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.requests.BankAccountRequestDTO;
import com.sinam.mybank.service.BankAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bank-accounts")
@Tag(name = "Bank Account Controller")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccountDTO> getBankAccounts(
            @RequestParam(name = "bankAccountId", required = false) Long bankAccountId,
            @RequestParam(name = "userPin", required = false) String pin
    ) {
        return bankAccountService.getBankAccounts(bankAccountId, pin);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@permissionService.hasPermission({'ADMIN','USER'})")
    public BankAccountDTO getBankAccount(@PathVariable Long id) {
        return bankAccountService.getBankAccount(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBankAccount(@PathVariable Long id, @RequestBody BankAccountRequestDTO userRequestDTO) {
        bankAccountService.updateBankAccount(id, userRequestDTO);
    }

    @GetMapping("/activate/{bankAccountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activateBankAccount(@PathVariable Long bankAccountId) {
        bankAccountService.activateBankAccount(bankAccountId);
    }

    @PostMapping("/accounts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addBankAccount() {
        bankAccountService.addBankAccount();
    }

    @DeleteMapping("/deleting/{bankAccountId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBankAccount(@PathVariable Long bankAccountId) {
        bankAccountService.deleteBankAccount(bankAccountId);
    }

}
