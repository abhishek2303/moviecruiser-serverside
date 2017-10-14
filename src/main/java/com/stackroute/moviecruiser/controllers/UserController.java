package com.stackroute.moviecruiser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.moviecruiser.domains.User;
import com.stackroute.moviecruiser.servicecontracts.UserService;

@RestController
public class UserController implements BaseURI{
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/user/add") 
	public ResponseEntity addUser(RequestEntity<User> request) {
		User requestUser = request.getBody();
		//TODO: validate data and call service to store the user in the database
		
		User addedUser;
		try {
			addedUser = userService.addUser(requestUser);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Not able to add user", HttpStatus.CONFLICT);
		}
		
		return new ResponseEntity<User>(addedUser, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/user/delete")
	public ResponseEntity deleteUser(RequestEntity<User> reqUserId) {
		User userToDelete = reqUserId.getBody();
		
		long userId = userToDelete.getId();
		System.out.println(userId);
		
		try {
			userToDelete = userService.deleteUserById(userId);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Unable to delete user", HttpStatus.CONFLICT);
		}
		return new ResponseEntity<User>(userToDelete, HttpStatus.OK);
	}
	
	/*
	 * A function to return the a sample json format of the user
	 */
	@GetMapping(value="/randomuser") 
	public ResponseEntity<User> getUserFormat() {
		User user = new User();
		user.setEmail("");
		user.setFirstname("");
		user.setLastname("");
		user.setPassword("");
		user.setUsername("");
		user.setId(0L);
		user.setEnabled(true);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
