package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private double price;
    private int stock;
}
