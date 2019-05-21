package com.sample.sodamachine.util;

public interface SodaMachineState {
	
	public int INSERT_QUARTER =1;
	public int EJECT_QUARTER = 2;
	public int PUSH_BUTTON  = 3;
	
	public String insertQuarter();
	public String ejectQuarter() ;
	public String pushButton();
	public String dispense();

}
