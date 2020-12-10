package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.entities.User;

@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
