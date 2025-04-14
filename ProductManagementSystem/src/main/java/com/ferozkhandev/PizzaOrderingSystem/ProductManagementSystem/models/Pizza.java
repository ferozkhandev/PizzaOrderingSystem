package com.ferozkhandev.PizzaOrderingSystem.ProductManagementSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Pizza {
    @Id
    private int id;
    private String name;
    private double price;
    @OneToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    private PizzaSize size;
    @OneToOne
    @JoinColumn(name = "crust_id", referencedColumnName = "id")
    private Crust crust;
    @OneToOne
    @JoinColumn(name = "toppings_id", referencedColumnName = "id")
    private Toppings toppings;
}
