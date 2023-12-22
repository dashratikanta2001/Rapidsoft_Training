package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blog.dao.CategoryDao;
import com.blog.dto.CategoryDto;
import com.blog.entity.Category;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.response.Response;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Response<?> saveCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		System.out.println("Category present? = "+categoryDao.findByTitle(categoryDto.getCategoryTitle()));
		
		if(!categoryDao.findByTitle(categoryDto.getCategoryTitle()).isPresent())
		{
			
			Category category = DtoToCategory(categoryDto);
			
			Category savedCategory = this.categoryDao.save(category);
			
			if (savedCategory == null) {
				return new Response<>("Category not added", null, HttpStatus.BAD_REQUEST.value());
			}
			
			return new Response<>("New category added.", categoryToDto(savedCategory), HttpStatus.CREATED.value());
			
		}
		
		return new Response<>("Title : '"+categoryDto.getCategoryTitle()+"' already exist.", null, HttpStatus.BAD_REQUEST.value());
		
		
	}

	@Override
	public Response<?> updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category category = this.categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory = this.categoryDao.save(category);
		
		return new Response<>("category updated successfully.", categoryToDto(updatedCategory), HttpStatus.OK.value());
	}

	@Override
	public Response<?> deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category = this.categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
		
		try {
			this.categoryDao.deleteCategory(category);
			return new Response<>("Category deleted successfully.", null, HttpStatus.OK.value());
		} catch (Exception e) {
			// TODO: handle exception
			return new Response<>("Category not deleted.", null, HttpStatus.BAD_REQUEST.value());
		}
		

	}

	@Override
	public Response<?> getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category category = this.categoryDao.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", categoryId));
		
		return new Response<>("category found.", categoryToDto(category), HttpStatus.OK.value());
	}

	@Override
	public Response<?> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = this.categoryDao.findAll();
		
		List<CategoryDto> categoryDtos = categories.stream().map((category) ->this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		
		return new Response<>("All categories", categoryDtos, HttpStatus.OK.value());
	}
	
	public CategoryDto categoryToDto (Category category)
	{
		return modelMapper.map(category, CategoryDto.class);
	}
	public Category DtoToCategory (CategoryDto categoryDto)
	{
		return modelMapper.map(categoryDto, Category.class);
	}

}
