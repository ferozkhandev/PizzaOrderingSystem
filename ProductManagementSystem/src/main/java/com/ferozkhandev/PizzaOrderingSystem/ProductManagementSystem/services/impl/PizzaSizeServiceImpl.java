package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.PizzaSizeRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.PizzaSizeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PizzaSizeServiceImpl implements PizzaSizeService {

    private PizzaSizeRepository pizzaSizeRepository;
}
