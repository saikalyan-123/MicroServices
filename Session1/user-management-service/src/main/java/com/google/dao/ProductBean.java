package com.google.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")

public class ProductBean implements Serializable{
	
	@Id
	@Column(name="PID")
	private Integer productId = null;
	@Column(name="PNAME")
	private String productName = null;
	@Column(name="PRICE")
	private Float productPrice= null;
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductBean(Integer productId, String productName, Float productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}
	

	
	
	
}
