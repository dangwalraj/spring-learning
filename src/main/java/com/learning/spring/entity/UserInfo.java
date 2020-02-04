package com.learning.spring.entity;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@Column(name="LOCKED")
	private boolean locked;
	
	@Column(name="PASSWORD_EXPIRED")
	private boolean passwordExpired;
	
	@ManyToMany (fetch = FetchType.EAGER)
	@JoinTable(
			name = "ROLE_MAPPING", 
			joinColumns = @JoinColumn(name="USERID" , referencedColumnName = "USERID"),
			
			inverseJoinColumns = @JoinColumn(name="ROLEID", referencedColumnName = "ROLEID")
			)
	private Set<UserRoles> mappedRoles;
	
	public boolean isLocked() {
		return locked;
	}


	public void setLocked(boolean locked) {
		this.locked = locked;
	}


	public boolean isPasswordExpired() {
		return passwordExpired;
	}


	public void setPasswordExpired(boolean passwordExpired) {
		this.passwordExpired = passwordExpired;
	}


	public Set<UserRoles> getMappedRoles() {
		return mappedRoles;
	}


	public void setMappedRoles(Set<UserRoles> mappedRoles) {
		this.mappedRoles = mappedRoles;
	}


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
