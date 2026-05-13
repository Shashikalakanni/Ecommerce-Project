package com.ecommerce.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ecommerce.service.CartService;
import com.ecommerce.model.CartItem;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService service;

    @PostMapping("/add")
    public String add(@RequestParam Long userId,
                      @RequestParam Long productId,
                      @RequestParam int qty) {
        service.addToCart(userId, productId, qty);
        return "Added to cart";
    }

    @GetMapping("/{userId}")
    public List<CartItem> get(@PathVariable Long userId) {
        return service.getCart(userId);
    }
}
