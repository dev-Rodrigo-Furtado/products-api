package com.example.api.services;

import java.util.List;

import com.example.api.entities.Product;

public interface ProductService {
    
    Product persist(Product product);
    
    List<Product> getAll();

}
