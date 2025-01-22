package com.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.curd.model.request.UserRequest;
import com.curd.service.JwtAuthenticationService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private JwtAuthenticationService service;
	
	@PostMapping("/login")
	public String login(@RequestBody UserRequest users) {
		

		
		return service.verify(users);
	}
}

