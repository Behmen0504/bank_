package com.sinam.mybank.controller;

import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.requests.BankAccountRequestDTO;
import com.sinam.mybank.service.BankAccountService;
import com.sinam.mybank.service.auth.PermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/bank-accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final PermissionService permissionService;

    public BankAccountController(BankAccountService bankAccountService, PermissionService permissionService) {
        this.bankAccountService = bankAccountService;
        this.permissionService = permissionService;
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
    @PreAuthorize("@permissionService.hasPermission({'ADMIN'})")
    public BankAccountDTO getBankAccount(@PathVariable Long id) {
        return bankAccountService.getBankAccount(id);
    }

    @GetMapping("/get-user-bank-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("@permissionService.hasPermission({'USER'})")
    public BankAccountDTO getUserBankAccount(@PathVariable Long id) {
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBankAccount(@PathVariable Long id) {
        bankAccountService.deleteBankAccount(id);
    }

}
