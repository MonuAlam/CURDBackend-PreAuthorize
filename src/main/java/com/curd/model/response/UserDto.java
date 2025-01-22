package com.curd.model.response;

import com.curd.enums.Roles;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

	private Integer id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private Roles roles;
}
