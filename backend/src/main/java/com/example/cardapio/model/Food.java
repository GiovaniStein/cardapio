package com.example.cardapio.model;

import com.example.cardapio.dto.FoodRequestDto;
import com.example.cardapio.dto.FoodUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Table(name = "foods")
@Entity(name = "foods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {

    public Food(FoodRequestDto dto) {
        this.title = dto.title();
        this.image = dto.image();
        this.price = dto.price();
    }

    public Food(FoodUpdateRequestDto dto) {
        this.id = dto.id();
        this.title = dto.title();
        this.image = dto.image();
        this.price = dto.price();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String image;
    private BigDecimal price;

}
