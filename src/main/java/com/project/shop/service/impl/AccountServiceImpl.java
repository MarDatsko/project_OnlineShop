package com.project.shop.service.impl;

import com.project.shop.dto.AccountDto;
import com.project.shop.model.Account;
import com.project.shop.repository.AccountRepo;
import com.project.shop.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountServiceImpl(AccountRepo accountRepo, ModelMapper modelMapper) {
        this.accountRepo = accountRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AccountDto> getAll() {
        List<AccountDto> authors = new ArrayList<>();
        accountRepo.findAll().forEach(account -> authors.add(modelMapper.map(account, AccountDto.class)));
        return authors;
    }

    @Override
    public AccountDto getById(Long id) {
        return modelMapper.map(accountRepo.findById(id).orElseThrow(), AccountDto.class);
    }

    @Override
    public AccountDto saveOrUpdate(Account account) {
        return modelMapper.map(accountRepo.save(account), AccountDto.class);
    }

    @Override
    public void delete(Long id) {
        accountRepo.deleteById(id);
    }
}
