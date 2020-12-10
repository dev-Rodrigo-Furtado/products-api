package com.example.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dtos.CategoryDto;
import com.example.api.entities.Category;
import com.example.api.response.Response;
import com.example.api.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<Response<Category>> insert(@Valid @RequestBody CategoryDto categoryDto,
			BindingResult result) {
		
		Response<Category> response = new Response<Category>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Category category = categoryDto.toCategory();
		categoryService.persist(category);
		
		response.setData(category);
		
		return ResponseEntity.ok(response);
	}

}