package com.example.api.service.impl;

import com.example.api.entities.Category;
import com.example.api.repositories.CategoryRepository;
import com.example.api.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
	private CategoryRepository categoryRepository;
	
	public Category persist(Category category) {
		return categoryRepository.save(category);
	}
 
}
