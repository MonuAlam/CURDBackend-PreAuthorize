package com.curd.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JwtAuthenticationRequest {

	private String email;
	private String password;
}
