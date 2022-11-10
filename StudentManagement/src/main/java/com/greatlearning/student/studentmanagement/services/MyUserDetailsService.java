package com.greatlearning.student.studentmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.student.studentmanagement.model.User;
import com.greatlearning.student.studentmanagement.repository.UserRepository;
import com.greatlearning.student.studentmanagement.security.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User name not available");
		}
		return new MyUserDetails(user);
	}

}
