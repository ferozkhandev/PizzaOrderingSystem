package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.controllers;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.PizzaSizeDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.PizzaSizeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pizzasize")
@AllArgsConstructor
public class PizzaSizeController {

    private final PizzaSizeService pizzaSizeService;

    @GetMapping("/getAll")
    @ExceptionHandler
    public ResponseEntity<List<PizzaSizeDTO>> getAllPizzaSizes(){
        return ResponseEntity.ok(pizzaSizeService.getAllPizzaSizes());
    }

    @GetMapping("/get/{id}")
    @ExceptionHandler
    public ResponseEntity<PizzaSizeDTO> getPizzaSizeById(@PathVariable Long id){
        return ResponseEntity.ok(pizzaSizeService.getPizzaSize(id));
    }

    @PostMapping("/add")
    @ExceptionHandler
    public ResponseEntity<String> addPizzaSize(PizzaSizeDTO pizzaSizeDTO) {
        if (pizzaSizeService.addPizzaSize(pizzaSizeDTO)) {
            return ResponseEntity.ok("Pizza size added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add this pizza size");
        }
    }

    @PutMapping("/update")
    @ExceptionHandler
    public ResponseEntity<PizzaSizeDTO> updatePizzaSize(PizzaSizeDTO pizzaSizeDTO) {
        return ResponseEntity.ok(pizzaSizeService.updatePizzaSize(pizzaSizeDTO));
    }

    @DeleteMapping("/delete")
    @ExceptionHandler
    public ResponseEntity<String> deletePizzaSize(PizzaSizeDTO pizzaSizeDTO) {
        if (pizzaSizeService.deletePizzaSize(pizzaSizeDTO.getId())) {
            return ResponseEntity.ok("Pizza size deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete this pizza size");
        }
    }
}