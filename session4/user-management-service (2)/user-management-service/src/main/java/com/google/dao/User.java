package com.google.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERINFO")
public class User implements  Serializable {
	
	@Id
	@Column(name="USER_ID")
	private String userId = null;
	@Column(name="PASSWORD")
	private String password = null;
	@Column(name="FIRST_NAME")
	private String first_Name = null;
	@Column(name="LAST_NAME")
	private String last_Name = null;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userId, String password, String first_Name, String last_Name) {
		super();
		this.userId = userId;
		this.password = password;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", first_Name=" + first_Name + ", last_Name="
				+ last_Name + "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	
	

}
