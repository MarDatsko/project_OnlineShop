package com.project.shop.service;

import com.project.shop.dto.AccountDto;
import com.project.shop.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    List<AccountDto> getAll();

    AccountDto getById(Long id);

    AccountDto saveOrUpdate(Account account);

    void delete(Long id);

}
