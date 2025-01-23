package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curd.model.request.UserRequest;
import com.curd.model.response.UserDto;
import com.curd.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public UserDto registerUser(@RequestBody UserRequest request) {

		return userService.registerUser(request);
	}

	@GetMapping
	public List<UserDto> getAllUsers() {
		
		return userService.getAllUsers();
	}
}
