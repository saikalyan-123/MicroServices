package com.google.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="USER_ACCOUNT")
public class UserAccount implements Serializable{
	
	@Id
	@Column(name="USER_ID")
	private String userId = null;
	@Column(name="BALANCE")
	private Integer balance = null;
	@Column(name="LAST_UPDATED")
	private Timestamp lastupdated = null;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinColumn(name="USER_FK_ID")
	@JsonManagedReference
 private Set<UserTransaction> userset = null;

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccount(String userId, Integer balance, Timestamp lastupdated, Set<UserTransaction> userset) {
		super();
		this.userId = userId;
		this.balance = balance;
		this.lastupdated = lastupdated;
		this.userset = userset;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Timestamp getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Timestamp lastupdated) {
		this.lastupdated = lastupdated;
	}

	public Set<UserTransaction> getUserset() {
		return userset;
	}

	public void setUserset(Set<UserTransaction> userset) {
		this.userset = userset;
	}
	
	
	
	
	

}
