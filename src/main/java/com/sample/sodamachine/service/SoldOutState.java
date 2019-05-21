package com.sample.sodamachine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.sodamachine.util.SodaMachineState;

public class SoldOutState implements SodaMachineState {
	private static final Logger log = LoggerFactory.getLogger(SodaMachine.class);
	SodaMachine sodaMachine;

	public SoldOutState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}
	public String insertQuarter() {
		String status = "Please wait, we’re already giving you "+sodaMachine.getProduct().getProductName();
		log.info(status);
		return status;
	}
	public String ejectQuarter() {
		String status = "Sorry, you already turned the push button to dispense the "+sodaMachine.getProduct().getProductName();
		log.info(status);
		return status;
	}
	public String pushButton() {
		String status = "Turning twice doesn’t get you another "+sodaMachine.getProduct().getProductName();
		log.info(status);
		return status;
	}
	public String dispense() {
		String status = sodaMachine.getProduct().getProductName()+" is dispensed ";
		return status;


	}
}
