package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.PizzaSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaSizeRepository extends JpaRepository<PizzaSize, Integer> {
}
