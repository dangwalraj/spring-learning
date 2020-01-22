package com.learning.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.entity.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userRepo;
	
	public UserInfo findByUserId(String userId)
	{
		return userRepo.findByUserId(userId);
	}
}
