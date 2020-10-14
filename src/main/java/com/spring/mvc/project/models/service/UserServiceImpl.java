package com.spring.mvc.project.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.project.models.entity.User;
import com.spring.mvc.project.models.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void save(User user) {
		userRepo.save(user);
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public User findById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
}