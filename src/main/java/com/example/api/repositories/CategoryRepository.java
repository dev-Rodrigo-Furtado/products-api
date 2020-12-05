package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
