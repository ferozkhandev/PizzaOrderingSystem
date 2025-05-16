package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.controllers;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.ToppingsDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.ToppingsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/toppings")
@AllArgsConstructor
public class ToppingsController {

    private final ToppingsService toppingsService;

    @GetMapping("/getAll")
    @ExceptionHandler
    public ResponseEntity<List<ToppingsDTO>> getAllToppings(){
        return ResponseEntity.ok(toppingsService.getAllToppings());
    }

    @GetMapping("/get/{id}")
    @ExceptionHandler
    public ResponseEntity<ToppingsDTO> getToppingById(@PathVariable Long id){
        return ResponseEntity.ok(toppingsService.getTopping(id));
    }

    @PostMapping("/add")
    @ExceptionHandler
    public ResponseEntity<String> addTopping(@RequestBody ToppingsDTO toppingsDTO) {
        if (toppingsService.addTopping(toppingsDTO)) {
            return ResponseEntity.ok("Topping added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add this topping");
        }
    }

    @PutMapping("/update")
    @ExceptionHandler
    public ResponseEntity<ToppingsDTO> updateTopping(@RequestBody ToppingsDTO toppingsDTO) {
        return ResponseEntity.ok(toppingsService.updateTopping(toppingsDTO));
    }

    @DeleteMapping("/delete")
    @ExceptionHandler
    public ResponseEntity<String> deleteTopping(@RequestBody ToppingsDTO toppingsDTO) {
        if (toppingsService.deleteTopping(toppingsDTO.getId())) {
            return ResponseEntity.ok("Topping deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete this topping");
        }
    }
}