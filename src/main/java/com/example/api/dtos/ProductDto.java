package com.example.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.api.entities.Category;
import com.example.api.entities.Product;

public class ProductDto {
	
	@NotEmpty
	private String name;
	
	@NotNull
	private Double price;
	
	@NotNull
	private Integer amount;
	
	@NotNull
	private Long categoryId;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getAmount() {
		return amount;
	}
	
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Product toProduct(Category category) {
		Product product = new Product();
		product.setName(this.name);
		product.setPrice(this.price);
		product.setAmount(this.amount);
		product.setCategory(category);

		return product;
	}
	

	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", price=" + price + ", amount=" + amount + "]";
	}
}