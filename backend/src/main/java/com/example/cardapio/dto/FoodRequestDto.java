package com.example.cardapio.dto;

import java.math.BigDecimal;

public record FoodRequestDto(String title, String image, BigDecimal price) {

}
