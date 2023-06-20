package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.exception.NullUserFoundException;


@Service
public interface UserService {

	public List<User> viewAllUser();

	public String deleteUser(User user);

	public User loginUser(String email, String password) throws NullUserFoundException;

	public User updateUser(User user);
    
	public List<User> getUserByuserId(int userId) throws Exception;

	public User addUser(User user);
}
