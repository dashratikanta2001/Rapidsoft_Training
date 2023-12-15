package com.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.entity.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
