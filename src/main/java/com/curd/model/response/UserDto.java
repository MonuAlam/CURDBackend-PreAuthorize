package com.curd.model.response;

import java.util.Set;

import com.curd.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Integer id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private Set<Role> roles;
}
