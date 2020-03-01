package com.project.shop.service.impl;

import com.project.shop.dto.CategoryDto;
import com.project.shop.model.Category;
import com.project.shop.repository.CategoryRepo;
import com.project.shop.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo, ModelMapper modelMapper) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryList = new ArrayList<>();
        categoryRepo.findAll().forEach(category -> categoryList.add(modelMapper.map(category, CategoryDto.class)));
        return categoryList;
    }

    @Override
    public CategoryDto getById(Long id) {
        return modelMapper.map(categoryRepo.findById(id).orElseThrow(), CategoryDto.class);
    }

    @Override
    public CategoryDto saveOrUpdate(Category category) {

        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
