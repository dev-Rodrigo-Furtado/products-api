package com.example.api.services.impl;

import com.example.api.entities.Category;
import com.example.api.repositories.CategoryRepository;
import com.example.api.services.CategoryService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
	private CategoryRepository categoryRepository;
	
	public Category persist(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}

	@Override
	public void delete(Category category) {
		categoryRepository.delete(category);
	}

	@Override
	public List<Category> findByUserId(Long id) {
		return categoryRepository.findByUserId(id);
	}
	
}
