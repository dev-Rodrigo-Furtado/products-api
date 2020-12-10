package com.example.api.security.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class JwtAuthenticationDto {

	@NotEmpty(message = "Email must not be empty.")
	@Email(message = "Email invalid.")
	private String email;
	
	@NotEmpty(message = "Password must not be empty.")
	private String password;

	public JwtAuthenticationDto() {
	}

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

	@Override
	public String toString() {
		return "JwtAuthenticationRequestDto [email=" + email + ", password=" + password + "]";
	}

}
