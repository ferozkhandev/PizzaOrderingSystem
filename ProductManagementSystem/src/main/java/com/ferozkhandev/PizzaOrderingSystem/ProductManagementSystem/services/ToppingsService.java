package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.ToppingsDTO;

import java.util.List;

public interface ToppingsService {

    boolean addTopping(ToppingsDTO topping);

    List<ToppingsDTO> getAllToppings();

    ToppingsDTO getTopping(Long id);

    ToppingsDTO updateTopping(ToppingsDTO topping);

    boolean deleteTopping(Long id);
}
