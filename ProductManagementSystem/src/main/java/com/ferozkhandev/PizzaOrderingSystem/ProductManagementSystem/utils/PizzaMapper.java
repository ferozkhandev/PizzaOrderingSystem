package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Pizza;

public final class PizzaMapper {
    private PizzaMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static PizzaDTO toDto(Pizza pizza) {
        if (pizza == null) return null;

        PizzaDTO dto = new PizzaDTO();
        dto.setId(pizza.getId());
        dto.setName(pizza.getName());
        dto.setPrice(pizza.getPrice());
        dto.setSize(PizzaSizeMapper.toDto(pizza.getSize()));
        dto.setCrust(CrustMapper.toDto(pizza.getCrust()));
        dto.setToppings(ToppingsMapper.toDto(pizza.getToppings()));
        return dto;
    }
}