package com.blog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.CategoryDto;
import com.blog.response.ErrorResponse;
import com.blog.response.Response;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	//Create category
	@PostMapping("/")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		Response<?> createCategory = this.categoryService.saveCategory(categoryDto);
		
		if(createCategory.getStatus() == HttpStatus.CREATED.value())
		{
			return new ResponseEntity<>(createCategory, HttpStatus.CREATED);			
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(createCategory.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	//Update category
	@PutMapping("/{catId}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId)
	{
		Response<?> updateCategory = this.categoryService.updateCategory(categoryDto, catId);
		
		if(updateCategory.getStatus() == HttpStatus.OK.value())
		{
			return new ResponseEntity<>(updateCategory, HttpStatus.OK);			
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(updateCategory.getMessage(), false), HttpStatus.BAD_REQUEST);

	}
	
	
	//delete category
	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer catId)
	{
		Response<?> deleteCategory = this.categoryService.deleteCategory(catId);
		if (deleteCategory.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(deleteCategory, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponse<>(deleteCategory.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/{catId}")
	public ResponseEntity<?> categoryById(@PathVariable Integer catId)
	{
		Response<?> category = this.categoryService.getCategory(catId);
		
		return new ResponseEntity<>(category, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> allCategories()
	{
		Response<?> categories = this.categoryService.getCategories();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
	}
}
