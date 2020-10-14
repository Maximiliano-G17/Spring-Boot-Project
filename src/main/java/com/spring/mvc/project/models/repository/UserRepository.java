package com.spring.mvc.project.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.project.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}