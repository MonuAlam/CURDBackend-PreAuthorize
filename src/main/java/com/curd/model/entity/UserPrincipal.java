package com.curd.model.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {



	private Users user;

	public UserPrincipal(Users user) {
		this.user = user;
	}

	 @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {

	        return user.getRoles().stream()
	                   .map(role -> new SimpleGrantedAuthority(role.getName()))
	                   .collect(Collectors.toList());
	    }
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	
    @Override
    public boolean isAccountNonExpired() {
        return true; // Can implement custom logic
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Can implement custom logic
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Can implement custom logic
    }

    @Override
    public boolean isEnabled() {
        return true; // Can implement custom logic
    }
}
