package com.project.shop.service;

import com.project.shop.dto.OrderDto;
import com.project.shop.model.Order;
import com.project.shop.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    List<OrderDto> getAll();

    OrderDto getById(Long id);

    OrderDto saveOrUpdate(Order order);

    void delete(Long id);
}
