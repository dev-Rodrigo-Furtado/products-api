package com.example.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dtos.UserDto;
import com.example.api.entities.User;
import com.example.api.response.Response;
import com.example.api.services.UserService;
import com.example.api.utils.PasswordUtils;

@RestController
@RequestMapping(path = "/api/auth/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Response<User>> insertUser(@RequestBody UserDto userDto) {
		
		Response<User> response = new Response<User>();
		
		userDto.setPassword(PasswordUtils.gerarBCrypt(userDto.getPassword()));
		
		User user = userService.persist(userDto.toUser());
		user.setPassword(PasswordUtils.gerarBCrypt(user.getPassword()));
		
		response.setData(user);
		
		return ResponseEntity.ok(response);
	}
	

}
