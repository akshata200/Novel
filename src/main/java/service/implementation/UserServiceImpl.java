package service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User createUser(User user) throws Exception {
		
		// if username already exists, throw exception else create new user
		User local = this.userRepo.findByUsername(user.getUsername());
		// if local is not null i.e., user already exists
		if(local != null) {
			System.out.println("User already exists");
			throw new Exception("User already exists");
		}else {
			//if local is null i.e., no such user exists then save the user
			this.userRepo.save(user);
		}
		
		return user;		
	}

	@Override
	public User getUser(String username) throws Exception {
		User local = this.userRepo.findByUsername(username);
		// if no such user exists, throw exception
		if(local==null) {
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

}
