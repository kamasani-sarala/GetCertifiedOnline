package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.exception.NullUserFoundException;
import com.demo.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<User> viewAllUser() {
		// TODO Auto-generated method stub
		List<User> allUser = userRepository.findAll(); // Note : same as save
		return allUser;
		
	}

	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User loginUser(String email, String password)throws NullUserFoundException {
		// TODO Auto-generated method stub
		if(email.equals("")|| email.equals("string")|| password.equals("")|| password.equals("string")) {
			throw new NullUserFoundException("Email or Password Cannot be empty");
		}
			
		User u =  userRepository.findUserByEmailPassword(email, password);
		
		if(u == null) {
			throw new NullUserFoundException("Cant Login Parent Email and Password dont match");
		}
		
		return u;
	}

	

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> getUserByuserId(int userId)throws Exception {
		// TODO Auto-generated method stub
		 List<User> Users = new ArrayList<>();
			for (User user : Users) {
	            if (user.getUserId() == userId) {
	                return Users;
	            }
	        }

	        throw new Exception("User not found with userId: " + userId);
	    }
	

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
}

