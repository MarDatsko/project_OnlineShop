package com.project.shop.repository;

import com.project.shop.model.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepo extends CrudRepository<Position,Long> {
}
