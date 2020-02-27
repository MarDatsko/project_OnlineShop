package com.project.shop.service;

import com.project.shop.model.Account;
import com.project.shop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAll();

    Category getById(Long id);

    Category saveOrUpdate(Category category);

    void delete(Long id);
}
