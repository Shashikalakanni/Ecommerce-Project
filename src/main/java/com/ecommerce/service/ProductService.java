package com.ecommerce.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.model.Product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    public Product save(Product p) { return repo.save(p); }
    public List<Product> getAll() { return repo.findAll(); }
}
