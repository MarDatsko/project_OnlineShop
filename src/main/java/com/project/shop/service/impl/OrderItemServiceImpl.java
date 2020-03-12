package com.project.shop.service.impl;

import com.project.shop.dto.OrderItemDto;
import com.project.shop.model.OrderItem;
import com.project.shop.repository.OrderItemRepo;
import com.project.shop.service.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepo orderItemRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepo orderItemRepo, ModelMapper modelMapper) {
        this.orderItemRepo = orderItemRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderItemDto> getAll() {
        List<OrderItemDto> orderItemsList = new ArrayList<>();
        orderItemRepo.findAll().forEach(orderItem -> orderItemsList.add(modelMapper.map(orderItem, OrderItemDto.class)));
        return orderItemsList;
    }

    @Override
    public OrderItemDto getById(Long id) {
        OrderItem orderItem = orderItemRepo.findById(id).orElse(null);
        if (orderItem == null) {
            return null;
        }
        return modelMapper.map(orderItem, OrderItemDto.class);
    }

    @Override
    public OrderItemDto saveOrUpdate(OrderItem orderItem) {
        return modelMapper.map(orderItemRepo.save(orderItem), OrderItemDto.class);
    }

    @Override
    public void delete(Long id) {
        orderItemRepo.deleteById(id);
    }
}
