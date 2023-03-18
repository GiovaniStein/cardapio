package com.example.cardapio.service;

import com.example.cardapio.dto.FoodRequestDto;
import com.example.cardapio.dto.FoodResponseDto;
import com.example.cardapio.dto.FoodUpdateRequestDto;
import com.example.cardapio.model.Food;
import com.example.cardapio.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<FoodResponseDto> findAll() {
        List<Food> allFood = foodRepository.findAll();
        return allFood.stream().map(FoodResponseDto::new).collect(Collectors.toList());
    }

    public Food create(FoodRequestDto food) {
        Food newFood = new Food(food);
        return foodRepository.save(newFood);
    }

    public Food update(FoodRequestDto food, String id) {
        Food newFood = new Food(food);
        newFood.setId(id);
        return foodRepository.save(newFood);
    }
}
