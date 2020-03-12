package com.project.shop.service;

import com.project.shop.dto.UserDto;
import com.project.shop.model.Position;
import com.project.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserDto> getAll();

    UserDto getById(Long id);

    UserDto saveOrUpdate(User user);

    void delete(Long id);

    UserDto findByAccount_UserName(String username);
}
