package com.example.novel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.novel.model.User;



public interface UserRepository extends JpaRepository<User,Long> {
	
	public User findByUsername(String username);

}
