package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Crust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrustRepository extends JpaRepository<Crust, Long> {
}
