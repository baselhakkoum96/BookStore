package com.example.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
	private final UserRepository repository;

	@Autowired
	public UserDetailService(UserRepository userRepository) {
		super();
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		User currentuser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, currentuser.getPassword(), 
        		AuthorityUtils.createAuthorityList(currentuser.getRole()));
        return user;
	}
	
	
	


}