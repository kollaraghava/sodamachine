package com.sample.sodamachine.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sample.sodamachine.repository.Inventory;
import com.sample.sodamachine.repository.InventoryRepository;
import com.sample.sodamachine.repository.Product;
import com.sample.sodamachine.repository.Sales;
import com.sample.sodamachine.repository.SalesRepository;
import com.sample.sodamachine.util.SodaMachineState;



public class SodaMachine {

	SodaMachineState soldOutState;
	SodaMachineState noQuarterState;
	SodaMachineState hasQuarterState;
	SodaMachineState soldState;
	SodaMachineState sodaMachineState = soldOutState;

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Autowired
	SalesRepository salesRepository;

	private static final Logger log = LoggerFactory.getLogger(SodaMachine.class);

	
	Inventory inventory;

	int count ;
	
	Product product;



	public SodaMachine() {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);	
	}

	public void setProductDetails(Product product,Inventory invnetory) {
		this.product = product;
		this.inventory = invnetory;
		this.count = invnetory.getQuantity();
		if (count > 0) {
			sodaMachineState = noQuarterState;
		}
	}

	public String insertQuarter() {
		return sodaMachineState.insertQuarter();
	}
	public String ejectQuarter() {
		return sodaMachineState.ejectQuarter();
	}
	public String pushButton() {
		return sodaMachineState.pushButton()+"  "+sodaMachineState.dispense();
	}
	void setSodaMachineState(SodaMachineState sodaMachineState) {
		this.sodaMachineState = sodaMachineState;
	}
	void releaseProduct() {
		log.info("A "+product.getProductName()+" comes rolling out the slot...");
		if (null != inventory) {			
			inventory.setQuantity(inventory.getQuantity() -1);
			inventoryRepository.save(inventory);
			Sales sale = new Sales(product,new Date());
			salesRepository.save(sale);
		}
	}

	public SodaMachineState getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(SodaMachineState soldOutState) {
		this.soldOutState = soldOutState;
	}

	public SodaMachineState getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(SodaMachineState noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public SodaMachineState getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(SodaMachineState hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public SodaMachineState getSoldState() {
		return soldState;
	}

	public void setSoldState(SodaMachineState soldState) {
		this.soldState = soldState;
	}

	public SodaMachineState getSodaMachineState() {
		return sodaMachineState;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	
	 public int getCount() { return count; }
	 
	

}