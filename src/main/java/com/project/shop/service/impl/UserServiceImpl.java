package com.project.shop.service.impl;

import com.project.shop.dto.UserDto;
import com.project.shop.model.User;
import com.project.shop.repository.UserRepo;
import com.project.shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {
        List<UserDto> userList = new ArrayList<>();
        userRepo.findAll().forEach(user -> userList.add(modelMapper.map(user, UserDto.class)));
        return userList;
    }

    @Override
    public UserDto getById(Long id) {
        return modelMapper.map(userRepo.findById(id).orElseThrow(), UserDto.class);
    }

    @Override
    public UserDto saveOrUpdate(User user) {
        return modelMapper.map(userRepo.save(user), UserDto.class);
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDto findByAccount_UserName(String username) {
        return modelMapper.map(userRepo.findByAccount_UserName(username),UserDto.class);
    }
}
