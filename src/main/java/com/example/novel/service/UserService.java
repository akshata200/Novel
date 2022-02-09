package com.example.novel.service;

import java.util.List;

import com.example.novel.model.User;

public interface UserService {

	// create user
	public User createUser(User user) throws Exception;
	
	// get user by username
	public User getUser(String username) throws Exception;
	
	// delete user by userId
	public void deleteUser(Long userId);
	
	// update user details
	// update username
	public void updateUsername(String oldUsername, String newUsername) throws Exception;
	
	// update password by username
	public void updatePassword(String username, String password);
	
	// update email by username
	public void updateEmail(String username, String email);
	
	// update role by username
	public void updateRole(String username, String role);
	
	// user login with password and username
	public User userLogin(User user);
	
	
	// add book to reading list
	public void addToReadingList(String username, String bookname);
	
	// add book to writing list
	public void addToWritingList(String username, String bookname);
	
	// display reading list
	public List<String> showReadingList(String username);
	
	// display writing list
	public List<String> showWritingList(String username);
	
	// delete book from reading list
	public void deleteFromReadingList(String username, String bookname);
	
	// delete book from writing list
	public void deleteFromWritingList(String username, String bookname);
}
