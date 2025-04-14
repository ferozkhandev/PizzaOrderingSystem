package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.CrustDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Crust;

public final class CrustMapper {
    private CrustMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static CrustDTO toDto(Crust crust) {
        if (crust == null) return null;

        CrustDTO dto = new CrustDTO();
        dto.setId(crust.getId());
        dto.setName(crust.getName());
        return dto;
    }
}
