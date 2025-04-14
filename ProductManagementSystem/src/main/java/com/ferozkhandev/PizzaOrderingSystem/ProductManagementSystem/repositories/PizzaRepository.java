package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Integer> {
}
