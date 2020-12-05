package com.example.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entities.Category;
import com.example.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByCategory(Category category);
}
