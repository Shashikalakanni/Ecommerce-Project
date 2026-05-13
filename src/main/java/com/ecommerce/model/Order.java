package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name="orders")
public class Order {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
    private double totalAmount;
    private String status;
}
