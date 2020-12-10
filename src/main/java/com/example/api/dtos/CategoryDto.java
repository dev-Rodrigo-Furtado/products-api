package com.example.api.dtos;

import javax.validation.constraints.NotEmpty;

import com.example.api.entities.Category;

public class CategoryDto {

	@NotEmpty(message = "Name must not be empty.")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category toCategory() {
		Category category = new Category();
		category.setName(this.name);

		return category;
	}
	
	@Override
	public String toString() {
		return "CategoryDto [name=" + name + "]";
	}
}