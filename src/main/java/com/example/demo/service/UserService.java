package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	
	public User saveUser(User user) {
		
		User result = userRepository.save(user);
		
		return result;

	}
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public String deleteUserById(long id) {
		userRepository.deleteById(id);
		return "deleted";
	}
	
	public User updateUserById(User user) {
		User existingUser = userRepository.findById(user.getId()).orElse(null);
		 if (existingUser == null) {
		        return null; 
		    }
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		return userRepository.save(existingUser);
	}

	
}
