package com.blog.services;

import java.util.List;

import com.blog.dto.CategoryDto;
import com.blog.response.Response;

public interface CategoryService {

	Response<?> saveCategory(CategoryDto categoryDto);
	
	Response<?> updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	Response<?> deleteCategory(Integer categoryId);
	
	Response<?> getCategory(Integer categoryId);
	
	Response<?> getCategories();
}
