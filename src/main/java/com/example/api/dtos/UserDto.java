package com.example.api.dtos;

import com.example.api.entities.User;
import com.example.api.security.enums.ProfileEnum;

public class UserDto {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User toUser() {
		return new User(email, password, ProfileEnum.ROLE_USER);
	}

}
