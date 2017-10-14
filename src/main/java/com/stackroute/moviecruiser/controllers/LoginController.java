package com.stackroute.moviecruiser.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements BaseURI {
	//TODO: inject service
	
	
	@PostMapping(value = {"/authenticate"})
	public @ResponseBody ResponseEntity<String> comments(RequestEntity<String> request) {
		//TODO: service check for User Authentication
		String name = request.getBody();
		boolean auth = name.equals("Abhishek");
		
		//reponse entity
		ResponseEntity<String> response = 
			new ResponseEntity<String>(auth ? new String("User successfully authenticated") : new String("User unsuccessfully authenticated"), 
			HttpStatus.OK);
		
		return response;
	}
	
}
