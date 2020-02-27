package com.project.shop.service;

import com.project.shop.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    List<Account> getAll();

    Account getById(Long id);

    Account saveOrUpdate(Account account);

    void delete(Long id);

}
