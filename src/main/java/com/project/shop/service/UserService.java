package com.project.shop.service;

import com.project.shop.model.Position;
import com.project.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAll();

    User getById(Long id);

    User saveOrUpdate(User user);

    void delete(Long id);
}
