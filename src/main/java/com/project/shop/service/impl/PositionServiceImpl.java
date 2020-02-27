package com.project.shop.service.impl;

import com.project.shop.model.Position;
import com.project.shop.repository.PositionRepo;
import com.project.shop.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepo positionRepo;

    @Autowired
    public PositionServiceImpl(PositionRepo positionRepo) {
        this.positionRepo = positionRepo;
    }

    @Override
    public List<Position> getAll() {
        List<Position> positionList = new ArrayList<>();
        positionRepo.findAll().forEach(positionList::add);
        return positionList;
    }

    @Override
    public Position getById(Long id) {
        return positionRepo.findById(id).orElseThrow();
    }

    @Override
    public Position saveOrUpdate(Position position) {
        positionRepo.save(position);
        return position;
    }

    @Override
    public void delete(Long id) {
        positionRepo.deleteById(id);
    }
}
