package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaSizeDTO;

import java.util.List;

public interface PizzaSizeService {

    boolean addPizzaSize(PizzaSizeDTO pizzaSize);

    List<PizzaSizeDTO> getAllPizzaSizes();

    PizzaSizeDTO getPizzaSize(Long id);

    PizzaSizeDTO updatePizzaSize(PizzaSizeDTO pizzaSize);

    boolean deletePizzaSize(Long id);
}
