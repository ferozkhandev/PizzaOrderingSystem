package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaSizeDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.PizzaSize;

public final class PizzaSizeMapper {
    private PizzaSizeMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static PizzaSizeDTO toDto(PizzaSize pizzaSize) {
        if (pizzaSize == null) return null;

        PizzaSizeDTO dto = new PizzaSizeDTO();
        dto.setId(pizzaSize.getId());
        dto.setSize(pizzaSize.getSize());
        return dto;
    }
}