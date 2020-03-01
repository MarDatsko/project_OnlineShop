package com.project.shop.service;

import com.project.shop.dto.CategoryDto;
import com.project.shop.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryDto> getAll();

    CategoryDto getById(Long id);

    CategoryDto saveOrUpdate(Category category);

    void delete(Long id);
}
