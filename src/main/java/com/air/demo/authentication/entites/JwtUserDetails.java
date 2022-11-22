package com.air.demo.authentication.entites;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserDetails implements UserDetails {
	
	private String username;
	private String password;
	private boolean isActive;
	private List<String> listAuthority;

	public JwtUserDetails(String username, String password,boolean isActive) {
		super();
		this.username = username;
		this.password = password;
//		this.listAuthority = listAuthority;
		this.isActive = isActive;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return listAuthority.stream()
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
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

		return true;
	}

	@Override
	public boolean isEnabled() {

		return isActive;
	}

}
