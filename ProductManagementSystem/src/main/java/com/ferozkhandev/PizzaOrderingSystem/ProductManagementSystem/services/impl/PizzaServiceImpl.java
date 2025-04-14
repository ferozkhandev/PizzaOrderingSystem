package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.PizzaRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;
}
