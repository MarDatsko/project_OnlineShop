package com.project.shop.service.impl;

import com.project.shop.model.Order;
import com.project.shop.repository.OrderRepo;
import com.project.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public List<Order> getAll() {
        List<Order> ordersList = new ArrayList<>();
        orderRepo.findAll().forEach(ordersList::add);
        return ordersList;
    }

    @Override
    public Order getById(Long id) {
        return orderRepo.findById(id).orElseThrow();
    }

    @Override
    public Order saveOrUpdate(Order order) {
        orderRepo.save(order);
        return order;
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }
}
