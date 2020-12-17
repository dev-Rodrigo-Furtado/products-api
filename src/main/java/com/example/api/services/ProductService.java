package com.example.api.services;

import java.util.List;
import java.util.Optional;

import com.example.api.entities.Product;

public interface ProductService {
    
    Product persist(Product product);
    
    List<Product> getAll();
    
    Optional<Product> getById(Long id);

}
