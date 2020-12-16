package com.example.api.service.impl;

import com.example.api.entities.Product;
import com.example.api.repositories.ProductRepository;
import com.example.api.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
	public ProductRepository productRepository;
	
	public Product persist(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

}
