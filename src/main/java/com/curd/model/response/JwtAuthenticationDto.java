package com.curd.model.response;

import java.util.Set;
import com.curd.model.entity.Role;
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
	private Set<Role> roles;
}
