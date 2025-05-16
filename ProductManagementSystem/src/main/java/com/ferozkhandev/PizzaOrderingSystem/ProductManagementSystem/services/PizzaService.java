package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaDTO;

import java.util.List;

public interface PizzaService {

    boolean addPizza(PizzaDTO pizza);

    List<PizzaDTO> getAllPizzas();

    PizzaDTO getPizza(int id);

    PizzaDTO updatePizza(PizzaDTO pizza);

    boolean deletePizza(int id);
}
