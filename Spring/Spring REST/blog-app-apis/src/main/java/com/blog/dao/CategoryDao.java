package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

}
