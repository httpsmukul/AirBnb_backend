package com.air.demo.authentication.serviceImpl;

import com.air.demo.authentication.entites.JwtUserDetails;
import com.air.demo.user.Entity.user.User;
import com.air.demo.user.repository.UserRepository;
//import com.upcapita.common.dto.request.userDto.authenticationDto.JwtUserDetails;
//import com.upcapita.common.entities.user.User;
//import com.upcapita.common.repository.master.RoleRepository;
//import com.upcapita.common.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class JwtUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private RoleRepository roleRepository;
	
	@Autowired
	private Environment environment;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("yes35");
		User user = null;
		user = userRepository.findByUserName(username);
		System.out.println(user);
		boolean isActive = false;
		
//		if((List.of(Integer.parseInt(environment.getProperty("advisorSignedUp")),
//				Integer.parseInt(environment.getProperty("advisorProfileKycDetails")),
//				Integer.parseInt(environment.getProperty("advisorProfileExperienceDetails"))).contains(user.getJourneyStatus())
//				&& Integer.parseInt(environment.getProperty("inactiveStatus")) == user.getStatus())
//				&& Integer.parseInt(environment.getProperty("advisor")) ==  user.getRole().getId())
//		{
//			isActive = true;
//		}
		if(user.getStatus()== 1)
		{
			isActive = true;
		}
				
		UserDetails userDetails = new JwtUserDetails(username, user.getPassword(),isActive);
		
		return userDetails;
	}
	
	

}
