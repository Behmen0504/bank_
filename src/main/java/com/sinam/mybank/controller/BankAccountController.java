package com.sinam.mybank.controller;

import com.sinam.mybank.model.BankAccountDTO;
import com.sinam.mybank.model.requests.BankAccountRequestDTO;
import com.sinam.mybank.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/bank-accounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccountDTO> getBankAccounts(){
        return bankAccountService.getBankAccounts();
    }



    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccountDTO getBankAccount(@PathVariable Long id){
        return bankAccountService.getBankAccount(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBankAccount(@RequestBody BankAccountRequestDTO requestDTO){
        bankAccountService.addBankAccount(requestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBankAccount(@PathVariable Long id,@RequestBody BankAccountRequestDTO userRequestDTO){
        bankAccountService.updateBankAccount(id,userRequestDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBankAccount(@PathVariable Long id){
        bankAccountService.deleteBankAccount(id);
    }

}
