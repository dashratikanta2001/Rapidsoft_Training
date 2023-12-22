package com.blog.dao;

import java.util.List;
import java.util.Optional;

import com.blog.entity.Category;

public interface CategoryDao {

	Category save(Category category);
	
	void deleteCategory(Category category);
	
	Optional<Category> findById(Integer categoryId);
	
	List<Category> findAll();

	Optional<Category> findByTitle(String categoryTitle);
}
