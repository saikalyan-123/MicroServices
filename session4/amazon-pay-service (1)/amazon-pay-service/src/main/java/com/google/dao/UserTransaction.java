package com.google.dao;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="USER_TRANSACTION")
public class UserTransaction implements Serializable {
	
	
	@Id
	@GenericGenerator(name="icr" , strategy="increment")
	@GeneratedValue(generator="icr")
	@Column(name="TXN_ID")
	
	private String transactionId= null;
	@Column(name="AMOUNT_TRANSFERED")
	private Float amountTransfered = null;
	@Column(name="DATE_TIME")
	private Timestamp date_time = null;
	
	@Column(name="TXN_TYPE")
	private String txntype= null;
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.LAZY)

	@JoinColumn(name="USER_FK_ID")
	@JsonBackReference
	private UserAccount userAccount = null;

	public UserTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTransaction(String transactionId, Float amountTransfered, Timestamp date_time, String txntype,
			UserAccount userAccount) {
		super();
		this.transactionId = transactionId;
		this.amountTransfered = amountTransfered;
		this.date_time = date_time;
		this.txntype = txntype;
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "UserTransaction [transactionId=" + transactionId + ", amountTransfered=" + amountTransfered
				+ ", date_time=" + date_time + ", txntype=" + txntype + ", userAccount=" + userAccount + "]";
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Float getAmountTransfered() {
		return amountTransfered;
	}

	public void setAmountTransfered(Float amountTransfered) {
		this.amountTransfered = amountTransfered;
	}

	public Timestamp getDate_time() {
		return date_time;
	}

	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}

	public String getTxntype() {
		return txntype;
	}

	public void setTxntype(String txntype) {
		this.txntype = txntype;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	
	
	
	
	

}
