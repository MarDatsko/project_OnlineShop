package com.project.shop.service.impl;

import com.project.shop.model.Account;
import com.project.shop.repository.AccountRepo;
import com.project.shop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Account> getAll() {
        List<Account> authors = new ArrayList<>();
        accountRepo.findAll().forEach(authors::add);
        return authors;
    }

    @Override
    public Account getById(Long id) {
        return accountRepo.findById(id).orElseThrow();
    }

    @Override
    public Account saveOrUpdate(Account account) {
        accountRepo.save(account);
        return account;
    }

    @Override
    public void delete(Long id) {
        accountRepo.deleteById(id);
    }
}
