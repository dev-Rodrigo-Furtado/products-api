package com.example.api.services.impl;

import com.example.api.entities.Product;
import com.example.api.repositories.ProductRepository;
import com.example.api.services.ProductService;

import java.util.List;
import java.util.Optional;

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
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

}
