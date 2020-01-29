package com.learning.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learning.spring.beans.UserDetailsImpl;
import com.learning.spring.repository.UserInfoRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UserInfoRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		return new UserDetailsImpl(userRepo.findByUserId(userId));
	}
}
