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

import com.example.api.dtos.ProductDto;
import com.example.api.entities.Product;
import com.example.api.response.Response;
import com.example.api.services.ProductService;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Response<Product>> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult result) {
       Response<Product> response = new Response<Product>(); 

       if(result.hasErrors()) {
           result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
           return ResponseEntity.badRequest().body(response);
       }

       Product product = productService.persist(productDto.toProduct());

       response.setData(product);

       return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<Response<List<Product>>> getAllProducts() {
    	Response<List<Product>> response = new Response<List<Product>>();
    	
    	response.setData(productService.getAll());
    	
    	return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Response<Product>> getProductById(@PathVariable(value = "id") Long id) {
    	
    	Response<Product> response = new Response<Product>();
    	
    	Optional<Product> product = productService.getById(id);
    	
    	if(!product.isPresent()) {
    		response.getErrors().add("Produto não encontrado!");
    		return ResponseEntity.badRequest().body(response);
    	}
    	
    	response.setData(product.get());
    	
    	return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Response<Product>> updateProduct(@PathVariable Long id,
    		@Valid @RequestBody ProductDto productDto, BindingResult result) {
    	
    	Response<Product> response = new Response<Product>();
    	
    	Optional<Product> product = productService.getById(id);
    	
    	if(product.isEmpty()) {
    		response.getErrors().add("O produto não encontrado!");
    		return ResponseEntity.badRequest().body(response);
    	}
    	
    	Product productDtoConverted= productDto.toProduct();
    	Product productResponse = product.get();
    	productResponse.setName(productDtoConverted.getName());
    	productResponse.setPrice(productDtoConverted.getPrice());
    	productResponse.setAmount(productDtoConverted.getAmount());
    	
    	productService.persist(productResponse);
    	
    	response.setData(productResponse);
    	
    	return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Product>> deleteProduct(@PathVariable Long id) {
    	
    	Response<Product> response = new Response<Product>();
    	
    	Optional<Product> product = productService.getById(id);
    	
    	if(product.isEmpty()) {
    		response.getErrors().add("O produto não encontrado!");
    		return ResponseEntity.badRequest().body(response);
    	}
    
    	productService.delete(product.get());
    	
    	return ResponseEntity.ok(response);
    }
    
}
