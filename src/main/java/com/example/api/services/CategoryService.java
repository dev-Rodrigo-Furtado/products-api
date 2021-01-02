package com.example.api.services;

import java.util.List;
import java.util.Optional;

import com.example.api.entities.Category;

public interface CategoryService {

	Category persist(Category category);
	List<Category> findAll();
	Optional<Category> findById(Long id);
	void delete(Category category);
	List<Category> findByUserId(Long id);
}
