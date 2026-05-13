package com.ecommerce.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ecommerce.repository.*;
import com.ecommerce.model.*;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepo;
    private final CartItemRepository itemRepo;

    public void addToCart(Long userId, Long productId, int qty) {
    	Cart cart = cartRepo.findByUserId(userId)
    	        .orElseGet(() -> {
    	            Cart c = new Cart();
    	            c.setUserId(userId);
    	            return cartRepo.save(c);
    	        });

        CartItem item = new CartItem();
        item.setCartId(cart.getId());
        item.setProductId(productId);
        item.setQuantity(qty);
        itemRepo.save(item);
    }

    public List<CartItem> getCart(Long userId) {
        Cart cart = cartRepo.findByUserId(userId).orElseThrow();
        return itemRepo.findByCartId(cart.getId());
    }
}
