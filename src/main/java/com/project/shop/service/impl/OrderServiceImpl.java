package com.project.shop.service.impl;

import com.project.shop.dto.OrderDto;
import com.project.shop.model.Order;
import com.project.shop.repository.OrderRepo;
import com.project.shop.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo, ModelMapper modelMapper) {
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderDto> getAll() {
        List<OrderDto> ordersList = new ArrayList<>();
        orderRepo.findAll().forEach(order -> ordersList.add(modelMapper.map(order, OrderDto.class)));
        return ordersList;
    }

    @Override
    public OrderDto getById(Long id) {
        Order order = orderRepo.findById(id).orElseThrow();
        if (order == null) {
            return null;
        }
        return modelMapper.map(order, OrderDto.class);
    }

    @Override
    public OrderDto saveOrUpdate(Order order) {
        return modelMapper.map(orderRepo.save(order), OrderDto.class);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);
    }
}
