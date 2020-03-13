package com.project.shop.repository;

import com.project.shop.model.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepo extends CrudRepository<Position, Long> {

    List<Position> getAllPositionsByCategory_Id(Long id);
}
