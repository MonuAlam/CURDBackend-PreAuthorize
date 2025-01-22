package com.curd.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.curd.model.request.UserRequest;

@Service
public class JwtAuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	public String verify(UserRequest users) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));

		if (authentication.isAuthenticated()) {
			
			return jwtService.generateToken(users.getEmail());
		}

		return "Login Fail";
	}

}
