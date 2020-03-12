package com.project.shop.service.impl;

import com.project.shop.dto.PositionDto;
import com.project.shop.model.Position;
import com.project.shop.repository.PositionRepo;
import com.project.shop.service.PositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepo positionRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public PositionServiceImpl(PositionRepo positionRepo, ModelMapper modelMapper) {
        this.positionRepo = positionRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PositionDto> getAll() {
        List<PositionDto> positionList = new ArrayList<>();
        positionRepo.findAll().forEach(position -> positionList.add(modelMapper.map(position, PositionDto.class)));
        return positionList;
    }

    @Override
    public PositionDto getById(Long id) {
        Position position = positionRepo.findById(id).get();
        if (position == null) {
            return null;
        }
        return modelMapper.map(position, PositionDto.class);
    }

    @Override
    public PositionDto saveOrUpdate(Position position) {
        return modelMapper.map(positionRepo.save(position), PositionDto.class);
    }

    @Override
    public void delete(Long id) {
        positionRepo.deleteById(id);
    }
}
