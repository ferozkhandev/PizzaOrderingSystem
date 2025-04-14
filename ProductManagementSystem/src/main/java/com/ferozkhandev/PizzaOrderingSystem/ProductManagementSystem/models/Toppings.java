package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Toppings {
    @Id
    private Long id;
    private String name;
}
