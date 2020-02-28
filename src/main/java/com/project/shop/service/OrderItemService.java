package com.project.shop.service;

import com.project.shop.dto.OrderItemDto;
import com.project.shop.model.Category;
import com.project.shop.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {

    List<OrderItemDto> getAll();

    OrderItemDto getById(Long id);

    OrderItemDto saveOrUpdate(OrderItem orderItem);

    void delete(Long id);
}
