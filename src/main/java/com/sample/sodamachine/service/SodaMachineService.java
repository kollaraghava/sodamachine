package com.sample.sodamachine.service;

import java.util.List;

import com.sample.sodamachine.repository.Inventory;
import com.sample.sodamachine.repository.Product;
import com.sample.sodamachine.request.SodaMachineRequest;
import com.sample.sodamachine.response.SodaMachineReponse;

public interface SodaMachineService {

	public List<Product> getAllProducts();
	
	public List<Inventory> getInventory();
	
	public SodaMachineReponse performAction(SodaMachineRequest request);

}
