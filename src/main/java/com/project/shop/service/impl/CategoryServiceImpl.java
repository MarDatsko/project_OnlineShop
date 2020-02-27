package com.project.shop.service.impl;

import com.project.shop.model.Category;
import com.project.shop.repository.CategoryRepo;
import com.project.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();
        categoryRepo.findAll().forEach(categoryList::add);
        return categoryList;
    }

    @Override
    public Category getById(Long id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public Category saveOrUpdate(Category category) {
        categoryRepo.save(category);
        return category;
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
