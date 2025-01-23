package com.curd.model.response;

import com.curd.enums.Roles;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class JwtAuthenticationDto {

	private String username;
	private Boolean success;
	private String jwtToken;
	private String message;  
	private Roles roles;
}
