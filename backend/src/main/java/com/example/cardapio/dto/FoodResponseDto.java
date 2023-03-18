package com.example.cardapio.dto;

import com.example.cardapio.model.Food;

import java.math.BigDecimal;

public record FoodResponseDto(String id, String title, String image, BigDecimal price) {
    public FoodResponseDto(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }
}
