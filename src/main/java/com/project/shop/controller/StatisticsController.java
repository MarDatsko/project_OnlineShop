package com.project.shop.controller;

import com.project.shop.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
        private AccountServiceImpl accountService;

    @Autowired
    public StatisticsController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }


}
