package com.project.shop.service.impl;

import com.project.shop.model.User;
import com.project.shop.repository.UserRepo;
import com.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        userRepo.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepo.save(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
