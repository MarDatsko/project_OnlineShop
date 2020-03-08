package com.project.shop.controller;

import com.project.shop.dto.CategoryDto;
import com.project.shop.dto.PositionDto;
import com.project.shop.model.Position;
import com.project.shop.service.impl.CategoryServiceImpl;
import com.project.shop.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/position")
public class PositionController {
    private PositionServiceImpl positionService;
    private CategoryServiceImpl categoryService;

    @Autowired
    public PositionController(PositionServiceImpl positionService, CategoryServiceImpl categoryService) {
        this.positionService = positionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public ResponseEntity findAllPositions() {
        return ResponseEntity.status(HttpStatus.OK).body(positionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getAllPositionsByCategoryId(@PathVariable Long id) {


        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getById(id));
        //дістала по id категорію, а як з неї всі позиції вибрати - не знаю.
        //List<Position> positionsList = positionService.getAll();

     /*   @OneToMany
        @JoinTable(
                name = "position_category",
                joinColumns = @JoinColumn(name = "position_id"),
                inverseJoinColumns = @JoinColumn(name = "category_Id")
        )
        private List<Category> listCategoryId;
        */
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
