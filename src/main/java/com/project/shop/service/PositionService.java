package com.project.shop.service;

import com.project.shop.model.Order;
import com.project.shop.model.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {

    List<Position> getAll();

    Position getById(Long id);

    Position saveOrUpdate(Position position);

    void delete(Long id);
}
