package com.curd.model.request;

import java.util.Set;
import com.curd.model.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

	private String email;
	private String password;
	private String name;
	private String phone;
	private Set<Role> roles;
}
