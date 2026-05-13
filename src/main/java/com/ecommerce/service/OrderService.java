package com.ecommerce.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ecommerce.repository.*;
import com.ecommerce.model.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepo;
    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;
    private final ProductRepository productRepo;

    public Order checkout(Long userId) {
        Cart cart = cartRepo.findByUserId(userId).orElseThrow();
        List<CartItem> items = itemRepo.findByCartId(cart.getId());

        double total = 0;
        for (CartItem item : items) {
            Product p = productRepo.findById(item.getProductId()).orElseThrow();
            total += p.getPrice() * item.getQuantity();
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setStatus("CREATED");

        return orderRepo.save(order);
    }
}
