package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.ToppingsRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.ToppingsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ToppingsServiceImpl implements ToppingsService {

    private ToppingsRepository toppingsRepository;
}
