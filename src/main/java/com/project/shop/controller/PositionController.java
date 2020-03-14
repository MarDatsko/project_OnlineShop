package com.project.shop.controller;

import com.project.shop.dto.PositionDto;
import com.project.shop.model.Position;
import com.project.shop.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/position")
public class PositionController {
    private PositionServiceImpl positionService;


    @Autowired
    public PositionController(PositionServiceImpl positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/")
    public ResponseEntity findAllPositions() {
        return ResponseEntity.status(HttpStatus.OK).body(positionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PositionDto>> getAllPositionsByCategoryId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(positionService.getAllPositionsByCategoryId(id));
    }

    @PostMapping("/")
    public ResponseEntity createPosition(Position position) {
        PositionDto newPosition = positionService.saveOrUpdate(position);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPosition);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePosition(@PathVariable Long id, @RequestBody Position position) {
        PositionDto newPosition = positionService.getById(id);
        return newPosition != null
                ? new ResponseEntity<>(position, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePosition(@PathVariable Long id) {
        positionService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Position by id" + id + "was deleted successfully");
    }
}
