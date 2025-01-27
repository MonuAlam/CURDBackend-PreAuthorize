package com.curd.model.request;

import java.util.Set;
import com.curd.model.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private String email;
	private String password;
	private String name;
	private String phone;
	private Set<Role> roles;
}
