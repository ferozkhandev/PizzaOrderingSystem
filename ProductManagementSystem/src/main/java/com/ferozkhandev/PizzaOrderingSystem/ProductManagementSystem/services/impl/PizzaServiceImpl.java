package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.impl;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Crust;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Pizza;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.PizzaSize;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models.Toppings;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.CrustRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.PizzaRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.PizzaSizeRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.repositories.ToppingsRepository;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.PizzaService;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.utils.PizzaMapper;
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
public class PizzaServiceImpl implements PizzaService {

    private PizzaRepository pizzaRepository;
    private PizzaSizeRepository pizzaSizeRepository;
    private CrustRepository crustRepository;
    private ToppingsRepository toppingsRepository;

    @Override
    public boolean addPizza(PizzaDTO pizza) {
        try {
            Pizza newPizza = new Pizza();
            newPizza.setName(pizza.getName());
            newPizza.setPrice(pizza.getPrice());
            newPizza.setSize(pizza.getSize() != null ? pizzaSizeRepository.getReferenceById(pizza.getSize().getId()) : null);
            newPizza.setCrust(pizza.getCrust() != null ? crustRepository.getReferenceById(pizza.getCrust().getId()) : null);
            newPizza.setToppings(pizza.getToppings() != null ? toppingsRepository.getReferenceById(pizza.getToppings().getId()) : null);
            pizzaRepository.save(newPizza);
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
    public List<PizzaDTO> getAllPizzas() {
        return pizzaRepository.findAll().stream()
                .map(PizzaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PizzaDTO getPizza(int id) {
        Pizza pizza = pizzaRepository.findById(id).orElse(null);
        return PizzaMapper.toDto(pizza);
    }

    @Override
    public PizzaDTO updatePizza(PizzaDTO pizza) {
        Optional<Pizza> optionalPizza = pizzaRepository.findById(pizza.getId());
        if (optionalPizza.isPresent()) {
            Pizza existingPizza = optionalPizza.get();
            existingPizza.setName(pizza.getName());
            existingPizza.setPrice(pizza.getPrice());
            existingPizza.setSize(pizza.getSize() != null ? pizzaSizeRepository.getReferenceById(pizza.getSize().getId()) : null);
            existingPizza.setCrust(pizza.getCrust() != null ? crustRepository.getReferenceById(pizza.getCrust().getId()) : null);
            existingPizza.setToppings(pizza.getToppings() != null ? toppingsRepository.getReferenceById(pizza.getToppings().getId()) : null);
            return PizzaMapper.toDto(pizzaRepository.save(existingPizza));
        }
        return null;
    }

    @Override
    public boolean deletePizza(int id) {
        try {
            pizzaRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            log.error("Unexpected error during delete: {}", exception.getMessage());
            return false;
        }
    }
}
