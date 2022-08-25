package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long LoginId;
	@Column
    private String Password;
	@Column	
    private String Role;
	@Column(unique=true)
    private Long LinkedAccSeqID;
	@Column	
    private Long RoleId;
    
	
    
	public User() {
		super();
	}


	public User(Long loginId, String password, String role, Long linkedAccSeqID, Long roleId) {
		super();
		this.LoginId = loginId;
		this.Password = password;
		this.Role = role;
		this.LinkedAccSeqID = linkedAccSeqID;
		this.RoleId = roleId;
	}


	public Long getLoginId() {
		return LoginId;
	}


	public void setLoginId(Long loginId) {
		this.LoginId = loginId;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		this.Password = password;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		this.Role = role;
	}


	public Long getLinkedAccSeqID() {
		return LinkedAccSeqID;
	}


	public void setLinkedAccSeqID(Long linkedAccSeqID) {
		this.LinkedAccSeqID = linkedAccSeqID;
	}


	public Long getRoleId() {
		return RoleId;
	}


	public void setRoleId(Long roleId) {
		this.RoleId = roleId;
	}


	@Override
	public String toString() {
		return "User [LoginId=" + LoginId + ", Password=" + Password + ", Role=" + Role + ", LinkedAccSeqID="
				+ LinkedAccSeqID + ", RoleId=" + RoleId + "]";
	}
    
	
    
	
	



}
