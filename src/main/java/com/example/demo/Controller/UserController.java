package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/insertUser")
	public User insertUser(@RequestBody User user) {
		User result = userService.saveUser(user); 
		return result;
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public String deleteUserById(@PathVariable long id) {
		String result=userService.deleteUserById(id);
		return result;
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<User> updateUserById(@RequestBody User user) {
		User result = userService.updateUserById(user);
		if(result == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(result);
	}
	
	
	
	
}
