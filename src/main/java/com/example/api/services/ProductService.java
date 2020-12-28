package com.example.api.services;

import java.util.List;
import java.util.Optional;

import com.example.api.entities.Product;

public interface ProductService {
    
    Product persist(Product product);    
    List<Product> findAll();    
    Optional<Product> findById(Long id);    
    void delete(Product product);

}
