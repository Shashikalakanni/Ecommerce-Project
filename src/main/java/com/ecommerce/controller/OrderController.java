package com.ecommerce.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.ecommerce.service.OrderService;
import com.ecommerce.model.Order;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/checkout")
    public Order checkout(@RequestParam Long userId) {
        return service.checkout(userId);
    }
}
