package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.controllers;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizza")
@AllArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping("/getAll")
    @ExceptionHandler
    public ResponseEntity<List<PizzaDTO>> getAllPizzas(){
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }

    @GetMapping("/get/{id}")
    @ExceptionHandler
    public ResponseEntity<PizzaDTO> getPizzaById(@PathVariable int id){
        return ResponseEntity.ok(pizzaService.getPizza(id));
    }

    @PostMapping("/add")
    @ExceptionHandler
    public ResponseEntity<String> addPizza(@RequestBody PizzaDTO pizzaDTO) {
        if (pizzaService.addPizza(pizzaDTO)) {
            return ResponseEntity.ok("Pizza added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add this pizza");
        }
    }

    @PutMapping("/update")
    @ExceptionHandler
    public ResponseEntity<PizzaDTO> updatePizza(@RequestBody PizzaDTO pizzaDTO) {
        return ResponseEntity.ok(pizzaService.updatePizza(pizzaDTO));
    }

    @DeleteMapping("/delete")
    @ExceptionHandler
    public ResponseEntity<String> deletePizza(@RequestBody PizzaDTO pizzaDTO) {
        if (pizzaService.deletePizza(pizzaDTO.getId())) {
            return ResponseEntity.ok("Pizza deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete this pizza");
        }
    }
}