package com.project.shop.service;

import com.project.shop.model.Category;
import com.project.shop.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {

    List<OrderItem> getAll();

    OrderItem getById(Long id);

    OrderItem saveOrUpdate(OrderItem orderItem);

    void delete(Long id);
}
