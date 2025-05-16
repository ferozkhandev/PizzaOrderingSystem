package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.ToppingsDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Toppings;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.ToppingsRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.ToppingsService;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils.ToppingsMapper;
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
public class ToppingsServiceImpl implements ToppingsService {

    private ToppingsRepository toppingsRepository;

    @Override
    public boolean addTopping(ToppingsDTO topping) {
        try {
            Toppings newTopping = new Toppings();
            newTopping.setName(topping.getName());
            toppingsRepository.save(newTopping);
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
    public List<ToppingsDTO> getAllToppings() {
        return toppingsRepository.findAll().stream()
                .map(ToppingsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ToppingsDTO getTopping(Long id) {
        Toppings topping = toppingsRepository.findById(id).orElse(null);
        return ToppingsMapper.toDto(topping);
    }

    @Override
    public ToppingsDTO updateTopping(ToppingsDTO topping) {
        Optional<Toppings> optionalTopping = toppingsRepository.findById(topping.getId());
        return optionalTopping.map(value -> {
            value.setName(topping.getName());
            return ToppingsMapper.toDto(toppingsRepository.save(value));
        }).orElse(null);
    }

    @Override
    public boolean deleteTopping(Long id) {
        try {
            toppingsRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("Unexpected error during delete: {}", exception.getMessage());
            return false;
        }
    }
}
