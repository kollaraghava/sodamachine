package com.sample.sodamachine.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Integer productId;
	
	private String  productName;
	private String  productDescription;
	
	public Product() {}
	



	public Product(Integer productId, String productName, String productDescription, Integer price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		
	}
	
	public Product(String productName, String productDescription, Integer price) {
		super();
		
		this.productName = productName;
		this.productDescription = productDescription;
	
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + "]";
	}


}
