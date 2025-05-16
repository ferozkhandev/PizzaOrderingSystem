package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaSizeDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.PizzaSize;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.PizzaSizeRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.PizzaSizeService;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils.PizzaSizeMapper;
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
public class PizzaSizeServiceImpl implements PizzaSizeService {

    private PizzaSizeRepository pizzaSizeRepository;

    @Override
    public boolean addPizzaSize(PizzaSizeDTO pizzaSize) {
        try {
            PizzaSize newPizzaSize = new PizzaSize();
            newPizzaSize.setSize(pizzaSize.getSize());
            pizzaSizeRepository.save(newPizzaSize);
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
    public List<PizzaSizeDTO> getAllPizzaSizes() {
        return pizzaSizeRepository.findAll().stream()
                .map(PizzaSizeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaSizeDTO getPizzaSize(Long id) {
        PizzaSize pizzaSize = pizzaSizeRepository.findById(id).orElse(null);
        return PizzaSizeMapper.toDto(pizzaSize);
    }

    @Override
    public PizzaSizeDTO updatePizzaSize(PizzaSizeDTO pizzaSize) {
        Optional<PizzaSize> optionalPizzaSize = pizzaSizeRepository.findById(pizzaSize.getId());
        return optionalPizzaSize.map(value -> {
            value.setSize(pizzaSize.getSize());
            return PizzaSizeMapper.toDto(pizzaSizeRepository.save(value));
        }).orElse(null);
    }

    @Override
    public boolean deletePizzaSize(Long id) {
        try {
            pizzaSizeRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("Unexpected error during delete: {}", exception.getMessage());
            return false;
        }
    }
}
