package com.example.novel.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.novel.model.User;
import com.example.novel.repository.UserRepository;
import com.example.novel.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) throws Exception {

		// if username already exists, throw exception else create new user
		User local = this.userRepo.findByUsername(user.getUsername());
		// if local is not null i.e., user already exists
		if (local != null) {
			System.out.println("User already exists");
			throw new Exception("User already exists");
		} else {
			// if local is null i.e., no such user exists then save the user
			this.userRepo.save(user);
		}

		return user;
	}

	@Override
	public User getUser(String username) throws Exception {
		User local = this.userRepo.findByUsername(username);
		// if no such user exists, throw exception
		if (local == null) {
			System.out.println("No such user exists");
			throw new Exception("No such user exists");
		}
		// else return that user
		return local;
	}

	@Override
	public void deleteUser(Long userId) {

		this.userRepo.deleteById(userId);

	}

	@Override
	public User userLogin(User user) {
		User local = this.userRepo.findByUsername(user.getUsername());
		// if local is not null i.e., a user with given username is found
		// then check if given password is correct
		if (local != null) {
			if (user.getPassword().equals(local.getPassword())) {
				// if yes Login successful
				System.out.println("Login Successful");
				return local;
			} else {
				// else login fails
				System.out.println("Login Fails");
			}
		}
		return null;
	}

	@Override
	public void addToReadingList(String username, String bookname) {
		// find user by username and add bookname to user's reading list
		User local = this.userRepo.findByUsername(username);
		if (local != null) {
			// if local != null i.e., user is found, add bookname to user's reading list
			bookname=bookname.replace('-', ' ');
			local.addToReadingList(bookname);
			this.userRepo.save(local);
			System.out.println(bookname +" saved in "+username+" reading list");
		}

	}

	@Override
	public void addToWritingList(String username, String bookname) {
		// find user by username and add bookname to user's writing list
		User local = this.userRepo.findByUsername(username);
		if (local != null) {
			// if local != null i.e., user is found, check if user is writer
			// if user is writer then add book to writing list
			if(local.getRole().equals("writer")) {
				bookname=bookname.replace('-', ' ');
				local.addToWritingList(bookname);
				this.userRepo.save(local);
				System.out.println(bookname +" saved in "+username+" writing list");
			}
		}
	}

	@Override
	public List<String> showReadingList(String username) {
		User local = this.userRepo.findByUsername(username);
		if(local == null) {
			// if no such user exists
			return null;
		}
		return local.getReadingList();
	}

	@Override
	public List<String> showWritingList(String username) {
		User local = this.userRepo.findByUsername(username);
		if(local == null) {
			// if no such user exists
			return null;
		}
		return local.getWritingList();
	}

	@Override
	public void deleteFromReadingList(String username, String bookname) {
		// find user by username, if found remove that book from user's reading list
		User local = this.userRepo.findByUsername(username);
		if(local != null) {
			// if user exists, remove book
			bookname=bookname.replace('-', ' ');
			local.removeFromReadingList(bookname);
			this.userRepo.save(local);
			System.out.println(bookname +" remove from "+username+" reading list");
		}
		
	}

	@Override
	public void deleteFromWritingList(String username, String bookname) {
		User local = this.userRepo.findByUsername(username);
		if(local != null) {
			// if user exists, remove book
			bookname=bookname.replace('-', ' ');
			local.removeFromWritingList(bookname);
			this.userRepo.save(local);
			System.out.println(bookname +" remove from "+username+" writing list");
		}
	}

	@Override
	public void updateUsername(String oldUsername, String newUsername) throws Exception {
		User local = this.userRepo.findByUsername(oldUsername);
		if(local != null) {
			User temp = this.userRepo.findByUsername(newUsername);
			// if no user exists with newUsername, update it successfully else throw exception
			if(temp == null) {
				// no such user exists then update
				local.setUsername(newUsername);
				this.userRepo.save(local);
				System.out.println(oldUsername+" successfully updated to "+newUsername);
			}else {
				System.out.println("User with "+newUsername+" already exists. Please choose different username");
				throw new Exception("User already exists. Try with different username");
			}
		}else {
			System.out.println("No such user exists");
			throw new Exception("No such user exists");
		}
		
	}

	@Override
	public void updatePassword(String username, String password) {
		User local = this.userRepo.findByUsername(username);
		if(local != null) {
			// if user exists, update password
			local.setPassword(password);
			this.userRepo.save(local);
			System.out.println("Password updated");
		}	
	}

	@Override
	public void updateEmail(String username, String email) {
		User local = this.userRepo.findByUsername(username);
		if(local != null) {
			// if user exists, update email
			local.setEmail(email);
			this.userRepo.save(local);
			System.out.println("Email updated");
		}
		
	}

	@Override
	public void updateRole(String username, String role) {
		User local = this.userRepo.findByUsername(username);
		if(local != null) {
			// if user exists, update role
			local.setRole(role);
			this.userRepo.save(local);
			System.out.println("Role updated");
		}
		
	}

}
