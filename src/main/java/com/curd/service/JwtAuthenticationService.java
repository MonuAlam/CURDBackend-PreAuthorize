package com.curd.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import com.curd.model.entity.Users;
import com.curd.model.request.JwtAuthenticationRequest;
import com.curd.model.response.JwtAuthenticationDto;
import com.curd.repository.UserRepository;

@Service
public class JwtAuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private UserRepository userRepository;

	public JwtAuthenticationDto verify(JwtAuthenticationRequest users) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(users.getEmail(), users.getPassword()));

		if (authentication.isAuthenticated()) {
			
			Users existingUser=userRepository.findByEmail(users.getEmail());
			
			  String token = jwtService.generateToken(users.getEmail());

	            return JwtAuthenticationDto.builder()
	            		.username(existingUser.getName())
	                    .success(true)
	                    .jwtToken(token)
	                    .message("Login Successful")
	                    .roles(existingUser.getRoles())
	                    .build();
		}

		 return JwtAuthenticationDto.builder()
		            .success(false)
		            .message("Login Fail")
		            .build();
	}

}
