package com.tcdevelop.restexample.security;


import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.tcdevelop.restexample.repository.UsuarioRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = Logger.getLogger(CustomUserDetailsService.class.getSimpleName());

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		CustomUserDetails userDetails = new CustomUserDetails(ur.findByLogin(login));
		return userDetails;
	}

}