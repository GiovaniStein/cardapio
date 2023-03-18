package com.example.cardapio.dto;

import java.math.BigDecimal;

public record FoodUpdateRequestDto(String id, String title, String image, BigDecimal price) {
}
