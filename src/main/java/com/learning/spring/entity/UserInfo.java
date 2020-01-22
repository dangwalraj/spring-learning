package com.learning.spring.entity;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="USERINFO")
public class UserInfo extends BaseEntity{
	
	@javax.persistence.Id
	@Column(name="ID")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private BigInteger Id;
	
	@Column(name="USERID")
	private String userId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PASSWORD")
	private String password;

	public String toString() {
		
		return convertObjectToString();
	}
	
	
	public BigInteger getId() {
		return Id;
	}

	public void setId(BigInteger id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
