package com.sample.sodamachine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.sodamachine.util.SodaMachineState;

public class HasQuarterState implements SodaMachineState {
	
	private static final Logger log = LoggerFactory.getLogger(NoQuarterState.class);
	SodaMachine sodaMachine;
	public HasQuarterState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}
	public String insertQuarter() {
		String status = "You can’t insert another quarter";
		log.info(status);
		return status;
	}
	public String ejectQuarter() {
		String status = "Quarter returned";
		log.info(status);
		sodaMachine.setSodaMachineState(sodaMachine.getNoQuarterState());
		return status;
	}
	public String pushButton() {
		String status = "You pushed the button...";
		sodaMachine.setSodaMachineState(sodaMachine.getSoldState());
		return status; 
	}
	public String dispense() {
		String status = "No product dispensed";
		return status; 
	}

}
