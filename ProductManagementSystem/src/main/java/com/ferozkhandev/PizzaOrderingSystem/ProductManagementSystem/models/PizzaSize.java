package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PizzaSize {
    @Id
    private Long id;
    private int size;
}
