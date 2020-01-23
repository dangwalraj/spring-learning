package com.learning.spring.repository;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring.entity.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepo;
	
	
	@Autowired private EntityManagerFactory entityManagerFactory;
	
	public UserInfo findByUserId(String userId)
	{
		return userInfoRepo.findByUserId(userId);
	}
}
