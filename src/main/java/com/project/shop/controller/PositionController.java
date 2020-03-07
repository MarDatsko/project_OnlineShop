package com.project.shop.controller;

import com.project.shop.dto.PositionDto;
import com.project.shop.model.Category;
import com.project.shop.model.Position;
import com.project.shop.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}") //не знаю як тут категорію задіяти згідно таски
    public ResponseEntity<PositionDto> getPositionById(@PathVariable Long id, @RequestParam Category category) {
        return ResponseEntity.status(HttpStatus.OK).body(positionService.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity createPosition(Position position) {
        PositionDto newPosition = positionService.saveOrUpdate(position);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPosition);
    }

    @PutMapping("/{id}") // створити в сервісі окремий метод для апдейту по id?
    public ResponseEntity<String> updatePosition(@PathVariable Long id, @RequestBody Position position) {
        positionService.saveOrUpdate(position);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Position " + position.toString() + " was updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePosition(@PathVariable Long id) {
        positionService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Position by id" + id + "was deleted successfully");
    }
}
