package com.project.shop.controller;

import com.project.shop.dto.AccountDto;
import com.project.shop.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private AccountServiceImpl accountService;

    @Autowired
    public AccountsController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getById(id));
    }
}
