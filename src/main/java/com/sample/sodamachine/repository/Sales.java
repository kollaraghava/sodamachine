package com.sample.sodamachine.repository;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sales {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Integer saledId;
	@ManyToOne
	private Product product;
	
	private Date timeOfSale;
	
	public Sales() {
		
	}

	public Sales(Product product, Date timeOfSale) {
		super();
		this.product = product;
		this.timeOfSale = timeOfSale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getTimeOfSale() {
		return timeOfSale;
	}

	public void setTimeOfSale(Date timeOfSale) {
		this.timeOfSale = timeOfSale;
	}
	
	
	

}
