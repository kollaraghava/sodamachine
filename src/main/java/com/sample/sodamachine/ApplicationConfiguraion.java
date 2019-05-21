package com.sample.sodamachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.sodamachine.service.SodaMachine;



@Configuration
public class ApplicationConfiguraion {
	
	@Bean 
	public SodaMachine sodaMachine() {
		return new SodaMachine();
	}

}
