package com.example.api.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.api.entities.Category;
import com.example.api.entities.User;

public class CategoryDto {

	@NotEmpty(message = "Name must not be empty.")
	private String name;
	
	@NotNull(message = "userEmail must not be null.")
	private String userEmail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Category toCategory(User user) {
		Category category = new Category();
		category.setName(this.name);
		category.setUser(user);

		return category;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "CategoryDto [name=" + name + "]";
	}
}