package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Cart {
    @Id @GeneratedValue
    private Long id;
    private Long userId;
}
