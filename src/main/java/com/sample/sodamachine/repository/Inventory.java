package com.sample.sodamachine.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Integer inventoryId;
	@ManyToOne
	@JoinColumn
	private Product product;
	private Integer quantity;
	
	public Inventory() {};
	
	
	public Inventory(Integer productId, Integer quantity) {
		super();
		
		this.product.setProductId(productId);
		this.quantity = quantity;
	}
	
	public Inventory(Product product, Integer quantity) {
		super();
		
		this.product = product;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Inventory [product=" + product.getProductName() + ", quantity=" + quantity + "]";
	}
	
	



}
