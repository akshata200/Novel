package service;

import model.User;

public interface UserService {
	
	// create user
	public User createUser(User user) throws Exception;
	
	// get user by username
	public User getUser(String username) throws Exception;
	
	// delete user by userId
	public void deleteUser(Long userId);
}
