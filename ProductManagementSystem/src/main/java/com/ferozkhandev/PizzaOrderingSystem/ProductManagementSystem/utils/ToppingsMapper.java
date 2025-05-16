package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.ToppingsDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Toppings;

public final class ToppingsMapper {
    private ToppingsMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ToppingsDTO toDto(Toppings toppings) {
        if (toppings == null) return null;

        ToppingsDTO dto = new ToppingsDTO();
        dto.setId(toppings.getId());
        dto.setName(toppings.getName());
        return dto;
    }
}