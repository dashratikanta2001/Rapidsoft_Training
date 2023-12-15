package com.blog.controllers;

import java.util.List;

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

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

//import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	//Create category
	@PostMapping("/")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);

		return new ResponseEntity<>(createCategory, HttpStatus.CREATED);

	}

	//update category
	@PutMapping("/{catId}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer catId) {
		CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto, catId);

		return new ResponseEntity<>(updateCategory, HttpStatus.OK);
	}


	//delete category
	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer catId) {
		this.categoryService.deleteCategory(catId);

		return new ResponseEntity<>(new ApiResponse("category is deleted successfully", true), HttpStatus.OK);
	}


	//get category by id
	@GetMapping("/{catId}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer catId) {
		CategoryDto Category = this.categoryService.getCategory(catId);

		return new ResponseEntity<>(Category, HttpStatus.OK);

	}


	//get all categories
	@GetMapping("/")
	public ResponseEntity<?> getCategory() {
		List<CategoryDto> categories = this.categoryService.getcategories();

		return new ResponseEntity<>(categories, HttpStatus.OK);

	}
}
