package com.example.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dtos.CategoryDto;
import com.example.api.entities.Category;
import com.example.api.response.Response;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Response<Category>> insert(@RequestBody CategoryDto categoryDto) {
		
		Response<Category> response = new Response<Category>();
		
		Category category = categoryDto.toCategory();
		categoryService.persist(category);
		
		response.setData(category);
		
		return ResponseEntity.ok(response);
	}

}