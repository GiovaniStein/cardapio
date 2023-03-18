package com.example.cardapio.controller;

import com.example.cardapio.dto.EntityCreateResponseDto;
import com.example.cardapio.dto.FoodRequestDto;
import com.example.cardapio.dto.FoodResponseDto;
import com.example.cardapio.model.Food;
import com.example.cardapio.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAll() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @PostMapping
    public ResponseEntity<EntityCreateResponseDto> create(@RequestBody FoodRequestDto food) {
        Food foodDb = foodService.create(food);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EntityCreateResponseDto(foodDb.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody FoodRequestDto food,
                                       @PathVariable("id") String id) {
        foodService.update(food, id);
        return ResponseEntity.ok().build();
    }
}
