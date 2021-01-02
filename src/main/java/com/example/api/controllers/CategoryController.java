package com.example.api.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dtos.CategoryDto;
import com.example.api.entities.Category;
import com.example.api.entities.User;
import com.example.api.response.Response;
import com.example.api.services.CategoryService;
import com.example.api.services.UserService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<Category>> insert(@Valid @RequestBody CategoryDto categoryDto,
			BindingResult result) {
		
		Response<Category> response = new Response<Category>();
		
		if( result.hasErrors() ) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<User> user = userService.findByEmail(categoryDto.getUserEmail());
		
		if(user.isEmpty()) {
			response.getErrors().add("Usuário não encontrado!");
			return ResponseEntity.badRequest().body(response);
		}
		
		Category category = categoryDto.toCategory(user.get());
		categoryService.persist(category);
		
		response.setData(category);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Category>>> findAll(){
		Response<List<Category>> response = new Response<List<Category>>();
		
		response.setData(categoryService.findAll());
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Category>> findById(@PathVariable Long id) {
		
		Response<Category> response = new Response<Category>();
		Optional<Category> category = categoryService.findById(id); 
		
		if(category.isEmpty()) {
			response.getErrors().add("Categoria não encontrada!");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(category.get());
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Response<Category>> update(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto,
			BindingResult result) {
		
		Response<Category> response = new Response<Category>();
		Optional<Category> category = categoryService.findById(id); 
		
		if(category.isEmpty()) {
			response.getErrors().add("Categoria não encontrada!");
			return ResponseEntity.badRequest().body(response);
		}
		
		category.get().setName(categoryDto.getName());
		categoryService.persist(category.get());
		response.setData(category.get());
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Response<Category>> delete(@PathVariable Long id) {
		Response<Category> response = new Response<Category>();
		
		Optional<Category> category = categoryService.findById(id);
		
		if(category.isEmpty()) {
			response.getErrors().add("Categoria não encontrada");
			return ResponseEntity.badRequest().body(response);
		}
		
		categoryService.delete(category.get());
		response.setData(category.get());
		return ResponseEntity.ok(response);		
	}

}