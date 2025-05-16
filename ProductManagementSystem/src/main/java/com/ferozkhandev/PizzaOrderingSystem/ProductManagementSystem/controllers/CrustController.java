package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.controllers;

import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.dto.CrustDTO;
import com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.services.CrustService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crust")
@AllArgsConstructor
public class CrustController {

    private final CrustService crustService;

    @GetMapping("/getAll")
    @ExceptionHandler
    public ResponseEntity<List<CrustDTO>> getAllCrusts(){
        return ResponseEntity.ok(crustService.getAllCrust());
    }

    @GetMapping("/get/{id}")
    @ExceptionHandler
    public ResponseEntity<CrustDTO> getCrustById(@PathVariable Long id){
        return ResponseEntity.ok(crustService.getCrust(id));
    }

    @PostMapping("/add")
    @ExceptionHandler
    public ResponseEntity<String> addCrust(@RequestBody CrustDTO crustDTO) {
        if (crustService.addCrust(crustDTO)) {
            return ResponseEntity.ok("Crust added successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to add this crust");
        }
    }

    @PutMapping("/update")
    @ExceptionHandler
    public ResponseEntity<CrustDTO> updateCrust(@RequestBody CrustDTO crustDTO) {
        return ResponseEntity.ok(crustService.updateCrust(crustDTO));
    }

    @DeleteMapping("/delete")
    @ExceptionHandler
    public ResponseEntity<String> deleteCrust(@RequestBody CrustDTO crustDTO) {
        if (crustService.deleteCrust(crustDTO.getId())) {
            return ResponseEntity.ok("Crust deleted successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to delete this crust");
        }
    }
}
