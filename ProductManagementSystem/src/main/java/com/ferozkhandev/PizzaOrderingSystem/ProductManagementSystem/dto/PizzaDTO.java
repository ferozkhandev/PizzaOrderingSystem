package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto;

import lombok.Data;

@Data
public class PizzaDTO {
    private int id;
    private String name;
    private double price;
    private PizzaSizeDTO size;
    private CrustDTO crust;
    private ToppingsDTO toppings;
}