package com.sample.sodamachine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.sodamachine.util.SodaMachineState;

public class SoldState implements SodaMachineState {
	SodaMachine sodaMachine;
	private static final Logger log = LoggerFactory.getLogger(SoldState.class);
	public SoldState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}
	public String insertQuarter() {
		String status = "Please wait, we are giving you "+sodaMachine.getProduct().getProductName();
		log.info(status);
		return status;
	}
	public String ejectQuarter() {
		String status = "Sorry, you already pushed the button to dispense "+sodaMachine.getProduct().getProductName();
		log.info(status);
		return status;
	}
	public String pushButton() {
		String status = "pushing twice doesn’t get you another "+sodaMachine.getProduct().getProductName();
		log.info(status);
		return status;
	}
	public String dispense() {
		sodaMachine.releaseProduct();
		if (sodaMachine.getCount() > 0) {
			String status = "dispensed "+sodaMachine.getProduct().getProductName()+"; comes rolling out the slot...";			
			sodaMachine.setSodaMachineState(sodaMachine.getNoQuarterState());
			return status;
		} else {
			String status = " Sodamachine is out of "+sodaMachine.getProduct().getProductName();
			log.info(status);
			sodaMachine.setSodaMachineState(sodaMachine.getSoldOutState());
			return status;
		}
	}
}


