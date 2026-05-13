package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class CartItem {
    @Id @GeneratedValue
    private Long id;
    private Long productId;
    private int quantity;
    private Long cartId;
}
