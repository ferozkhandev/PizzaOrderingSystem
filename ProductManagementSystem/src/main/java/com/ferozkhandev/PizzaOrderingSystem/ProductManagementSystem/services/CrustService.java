package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.CrustDTO;

import java.util.List;

public interface CrustService {

    boolean addCrust(CrustDTO crust);

    List<CrustDTO> getAllCrust();

    CrustDTO getCrust(Long id);

    CrustDTO updateCrust(CrustDTO crust);

    boolean deleteCrust(Long id);
}
