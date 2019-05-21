package com.sample.sodamachine.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class SodaMachineReponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2763783274235395708L;
	
	
	private String result;

       
    private HttpStatus httpStatus;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
    
    
	
	
	

}
