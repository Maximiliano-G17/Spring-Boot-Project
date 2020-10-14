package com.spring.mvc.project.models.service;

import java.util.List;

import com.spring.mvc.project.models.entity.User;

public interface IUserService{
	
	public void save(User user);
	public List<User> findAll();
	public User findById(Long id);
	public void deleteById(Long id);
}