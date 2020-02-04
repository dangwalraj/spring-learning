package com.learning.spring.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.learning.spring.entity.UserInfo;


public class UserDetailsImpl implements UserDetails {
	
	private UserInfo ui;
	
	public UserDetailsImpl(UserInfo ui)
	{
		this.ui  = ui;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		final List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		ui.getMappedRoles().forEach(role ->
			auths.add(new GrantedAuthorityImpl(role.getName())));
		return auths;
	}

	@Override
	public String getPassword() {
			return this.ui.getPassword();
	}

	@Override
	public String getUsername() {
		return this.ui.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

class GrantedAuthorityImpl implements GrantedAuthority{

	private String role;
	public GrantedAuthorityImpl(String role)
	{
		this.role = role;
	}
	@Override
	public String getAuthority() {
		return this.role;
	}
	
}