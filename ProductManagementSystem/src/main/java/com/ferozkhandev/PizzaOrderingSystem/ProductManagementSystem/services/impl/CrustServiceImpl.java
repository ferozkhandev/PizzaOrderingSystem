package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.CrustDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Crust;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.CrustRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.CrustService;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils.CrustMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CrustServiceImpl implements CrustService {

    private CrustRepository crustRepository;

    @Override
    public boolean addCrust(CrustDTO crust) {
        try {
            Crust newCrust = new Crust();
            newCrust.setName(crust.getName());
            crustRepository.save(newCrust);
            return true;
        } catch (DataIntegrityViolationException e) {
            log.error("Constraint violated: {}", e.getMessage());
            return false;
        } catch (TransactionSystemException e) {
            log.error("Transaction failed: {}", e.getMessage());
            return false;
        } catch (Exception e) {
            log.error("Unexpected error during save: {}", e.getMessage());
            return false;
        }
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
    public CrustDTO updateCrust(CrustDTO crust) {
        Optional<Crust> optionalCrust = crustRepository.findById(crust.getId());
        return optionalCrust.map(value -> CrustMapper.toDto(crustRepository.save(value))).orElse(null);
    }

    @Override
    public boolean deleteCrust(Long id) {
        try {
            crustRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("Unexpected error during delete: {}", exception.getMessage());
            return false;
        }
    }
}
