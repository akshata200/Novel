package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String username;
	private String email;
	private String password;
	private String role;
	private List<String> readingList = null;
	private List<String> writingList = null;
	
	public User() {
		
	}

	public User(Long userId, String username, String email, String password, String role) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getReadingList() {
		return readingList;
	}

	public void setReadingList(String bookname) {
		this.readingList.add(bookname);
	}

	public List<String> getWritingList() {
		return writingList;
	}

	public void setWritingList(String bookname) {
		this.writingList.add(bookname);
	}
	
	
	
	
}
