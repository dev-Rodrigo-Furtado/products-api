package com.example.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.entities.User;
import com.example.api.repositories.UserRepository;
import com.example.api.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Optional<User> findByEmail(String email) {
		return Optional.ofNullable(this.userRepository.findByEmail(email));
	}

	@Override
	public User persist(User user) {

		return userRepository.save(user);
	}
}
