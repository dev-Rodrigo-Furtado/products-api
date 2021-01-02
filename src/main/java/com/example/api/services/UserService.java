package com.example.api.services;

import java.util.Optional;

import com.example.api.entities.User;

public interface UserService {

	/**
	 * Busca e retorna um usuário dado um email.
	 * 
	 * @param email
	 * @return Optional<User>
	 */
	User persist(User user);
	Optional<User> findByEmail(String email);
}
