package com.example.novel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.novel.model.User;
import com.example.novel.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create user
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		System.out.println("Creating user");
		return this.userService.createUser(user);
	}
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) throws Exception {
		return this.userService.getUser(username);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	@PostMapping("/login")
	public User userLogin(@RequestBody User user) {
		return this.userService.userLogin(user);
	}
	
	@GetMapping("/{username}/read/{bookname}")
	public void addToReadingList(@PathVariable("username") String username, @PathVariable("bookname") String bookname) {
		this.userService.addToReadingList(username, bookname);
	}
	
	@GetMapping("/{username}/write/{bookname}")
	public void addToWritingList(@PathVariable("username") String username, @PathVariable("bookname") String bookname) {
		this.userService.addToWritingList(username, bookname);
	}
	
	@GetMapping("/{username}/read")
	public List<String> showReadingList(@PathVariable("username") String username) {
		return this.userService.showReadingList(username);
	}
	
	@GetMapping("/{username}/write")
	public List<String> showWritingList(@PathVariable("username") String username) {
		return this.userService.showWritingList(username);
	}
	
	@DeleteMapping("/{username}/read/remove/{bookname}")
	public void removeFromReadingList(@PathVariable("username") String username, @PathVariable("bookname") String bookname) {
		this.userService.deleteFromReadingList(username, bookname);
	}
	
	@DeleteMapping("/{username}/write/remove/{bookname}")
	public void removeFromWritingList(@PathVariable("username") String username, @PathVariable("bookname") String bookname) {
		this.userService.deleteFromWritingList(username, bookname);
	}
	
	@PostMapping("{username}/update/username")
	public void updateUsername(@PathVariable("username") String oldUsername, @RequestBody User user) throws Exception {
		this.userService.updateUsername(oldUsername, user.getUsername());
	}
	
	@PostMapping("{username}/update/password")
	public void updatePassword(@PathVariable("username") String username, @RequestBody User user){
		this.userService.updatePassword(username, user.getPassword());
	}
	@PostMapping("{username}/update/email")
	public void updateEmail(@PathVariable("username") String username, @RequestBody User user){
		this.userService.updateEmail(username, user.getEmail());
	}
	@PostMapping("{username}/update/role")
	public void updateRole(@PathVariable("username") String username, @RequestBody User user){
		this.userService.updateRole(username, user.getRole());
	}
}
