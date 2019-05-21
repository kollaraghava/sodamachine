package com.sample.sodamachine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.sodamachine.repository.Inventory;
import com.sample.sodamachine.repository.Product;
import com.sample.sodamachine.repository.ProductRepository;
import com.sample.sodamachine.request.SodaMachineRequest;
import com.sample.sodamachine.response.SodaMachineReponse;
import com.sample.sodamachine.service.SodaMachineService;
import com.sample.sodamachine.util.SodaMachineUtil;

@RestController
@RequestMapping("/api/sodamachine")
public class SodaMachineContoller {

	@Autowired
	SodaMachineService sodaMachineService;
	
	@Autowired
	ProductRepository productRepository;


	@GetMapping("/products")	
	public ResponseEntity<List<Product>> listProducts() {

		List<Product> productList = sodaMachineService.getAllProducts();
		if (productList.isEmpty()) 
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}



	@GetMapping("/inventory")	
	public ResponseEntity<List<Inventory>> listInventory() {

		List<Inventory> inventory = sodaMachineService.getInventory();
		if (inventory.isEmpty()) 
			return new ResponseEntity(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Inventory>>(inventory, HttpStatus.OK);
	}

	@PostMapping(value = "/perform")
	public ResponseEntity<SodaMachineReponse> acessSodaMachine(@RequestBody SodaMachineRequest request) {

		SodaMachineReponse response = sodaMachineService.performAction(request);

		return new ResponseEntity<SodaMachineReponse>(response,response.getHttpStatus());

	}

}
