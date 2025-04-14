package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Toppings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingsRepository extends JpaRepository<Toppings, Integer> {
}
