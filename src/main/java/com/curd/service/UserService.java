package com.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.curd.model.entity.Users;
import com.curd.model.request.UserRequest;
import com.curd.model.response.UserDto;
import com.curd.repository.UserRepository;
import com.curd.util.UserDtoMapper;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	public UserDto registerUser(UserRequest request) {
		Users user = toEntity(request);
		
		return UserDtoMapper.toResponseDto(userRepository.save(user));
	}

	private Users toEntity(UserRequest request) {

		return Users.builder()
				.email(request.getEmail())
				.password(bCryptPasswordEncoder.encode(request.getPassword()))
				.name(request.getName())
				.phone(request.getPhone())
				.build();
	}

	public List<UserDto> getAllUsers() {

		return userRepository.findAll().stream().map(UserDtoMapper::toResponseDto).toList();
	}
	
	
}
