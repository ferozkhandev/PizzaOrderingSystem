package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.CrustDTO;

import java.util.List;

public interface CrustService {

    void addCrust(CrustDTO crust);

    List<CrustDTO> getAllCrust();

    CrustDTO getCrust(Long id);

    void updateCrust(CrustDTO crust);

    void deleteCrust(Long id);
}
