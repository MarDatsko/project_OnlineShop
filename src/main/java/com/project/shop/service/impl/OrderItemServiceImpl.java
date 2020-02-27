package com.project.shop.service.impl;

import com.project.shop.model.OrderItem;
import com.project.shop.repository.OrderItemRepo;
import com.project.shop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepo orderItemRepo;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepo orderItemRepo) {
        this.orderItemRepo = orderItemRepo;
    }

    @Override
    public List<OrderItem> getAll() {
        List<OrderItem> orderItemsList = new ArrayList<>();
        orderItemRepo.findAll().forEach(orderItemsList::add);
        return orderItemsList;
    }

    @Override
    public OrderItem getById(Long id) {
        return orderItemRepo.findById(id).orElseThrow();
    }

    @Override
    public OrderItem saveOrUpdate(OrderItem orderItem) {
        orderItemRepo.save(orderItem);
        return orderItem;
    }

    @Override
    public void delete(Long id) {
        orderItemRepo.deleteById(id);
    }
}
