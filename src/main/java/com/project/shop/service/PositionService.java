package com.project.shop.service;

import com.project.shop.dto.PositionDto;
import com.project.shop.model.Order;
import com.project.shop.model.Position;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PositionService {

    List<PositionDto> getAll();

    PositionDto getById(Long id);

    PositionDto saveOrUpdate(Position position);

    void delete(Long id);

    List<PositionDto> getAllPositionsByCategoryId(Long id);
}
