package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.CrustDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Crust;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.CrustRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.CrustService;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils.CrustMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CrustServiceImpl implements CrustService {

    private CrustRepository crustRepository;

    @Override
    public void addCrust(CrustDTO crust) {
        Crust newCrust = new Crust();
        newCrust.setName(crust.getName());
        crustRepository.save(newCrust);
    }

    @Override
    public List<CrustDTO> getAllCrust() {
        return crustRepository.findAll().stream()
                .map(CrustMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CrustDTO getCrust(Long id) {
        Crust crust = crustRepository.findById(id).orElse(null);
        return CrustMapper.toDto(crust);
    }

    @Override
    public void updateCrust(CrustDTO crust) {
        crustRepository.findById(crust.getId()).ifPresent(newCrust -> crustRepository.save(newCrust));
    }

    @Override
    public void deleteCrust(Long id) {

    }
}
