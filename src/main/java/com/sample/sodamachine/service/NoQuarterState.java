package com.sample.sodamachine.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.sodamachine.util.SodaMachineState;

public class NoQuarterState implements SodaMachineState {
	
	private static final Logger log = LoggerFactory.getLogger(NoQuarterState.class);

	SodaMachine sodaMachine;

	public NoQuarterState(SodaMachine sodaMachine) {
		this.sodaMachine = sodaMachine;
	}
	public String insertQuarter() {
		String status = "You inserted a quarter";
		log.info(status);
		sodaMachine.setSodaMachineState(sodaMachine.hasQuarterState);
		return status;
	}
	public String ejectQuarter() {
		String status = "You haven’t inserted a quarter";
		log.info(status);
		return status;
	}
	public String pushButton() {
		String status = "You pushed the button, but there’s no quarter";
		log.info(status);
		return status;
	}
	public String dispense() {
		String status = "You need to pay first";
		log.info(status);
		return status;
	}

}
