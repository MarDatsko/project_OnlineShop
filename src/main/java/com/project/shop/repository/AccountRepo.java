package com.project.shop.repository;

import com.project.shop.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account,Long> {
}
