package com.learning.spring.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.spring.entity.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, BigInteger> {

	public UserInfo findByUserId(String userId);
}
