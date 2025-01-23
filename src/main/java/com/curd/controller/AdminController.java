package com.curd.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminapi")
public class AdminController {

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminWelcome() {
		return "Hello, Admin Welcome ";
	}
	
	@GetMapping("/users")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String userWelcome() {
		return "Hello, User Welcome ";
	}
}
