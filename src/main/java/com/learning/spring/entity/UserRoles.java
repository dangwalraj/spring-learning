package com.learning.spring.entity;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERROLES")
public class UserRoles extends BaseEntity {
	
	@javax.persistence.Id
	@Column(name="ID")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private BigInteger Id;
	
	@Column(name="ROLEID")
	private String roleId;
	
	@Column(name="ROLE_NAME")
	private String name;
	
	@ManyToMany(mappedBy = "mappedRoles")
	private Set<UserInfo> linkedUsers;
	
	public BigInteger getId() {
		return Id;
	}

	public void setId(BigInteger id) {
		Id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserInfo> getLinkedUsers() {
		return linkedUsers;
	}

	public void setLinkedUsers(Set<UserInfo> linkedUsers) {
		this.linkedUsers = linkedUsers;
	}


}
