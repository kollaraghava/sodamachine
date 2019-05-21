package com.sample.sodamachine.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sample.sodamachine.repository.Inventory;
import com.sample.sodamachine.repository.InventoryRepository;
import com.sample.sodamachine.repository.Product;
import com.sample.sodamachine.repository.ProductRepository;
import com.sample.sodamachine.request.SodaMachineRequest;
import com.sample.sodamachine.response.SodaMachineReponse;
import com.sample.sodamachine.util.SodaMachineState;

@Service
public class SodaMachineServiceImpl implements SodaMachineService{

	private static final Logger log = LoggerFactory.getLogger(SodaMachineServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	InventoryRepository inventoryRepository;


	@Autowired SodaMachine sodaMachine;



	public List<Product> getAllProducts(){
		return (List<Product>)  productRepository.findAll();
	}

	public List<Inventory> getInventory(){
		return (List<Inventory>)  inventoryRepository.findAll();
	}

	public SodaMachineReponse performAction(SodaMachineRequest request) {
		SodaMachineReponse response = new SodaMachineReponse();
		log.debug("request details product id "+request.getSelectedProductId()+" action list "+request.getActionTypeList());
		try {
			if(null != request) {
				int productId = request.getSelectedProductId();
				Product product = productRepository.findOne(productId);
				if(product == null) {
					response.setResult("not a valid product");
					response.setHttpStatus(HttpStatus.BAD_REQUEST);
				}

				Inventory inventory = inventoryRepository.findByProduct(product).get(0);
				sodaMachine.setProductDetails(product,inventory);
				log.debug("product details "+product.getProductName() +" available count "+inventory.getQuantity());
				
				StringBuilder result = new StringBuilder();

				for(Integer actionType :  request.getActionTypeList()) {

					if(SodaMachineState.INSERT_QUARTER == actionType){
						result.append(" ");
						result.append((sodaMachine.insertQuarter()));	
						response.setHttpStatus(HttpStatus.OK);
					}else if (SodaMachineState.EJECT_QUARTER == actionType){
						result.append(" ");
						result.append(sodaMachine.ejectQuarter());	
						response.setHttpStatus(HttpStatus.OK);
					}else if (SodaMachineState.PUSH_BUTTON == actionType){
						result.append(" ");
						result.append(sodaMachine.pushButton());	
						response.setHttpStatus(HttpStatus.OK);
					}else {
						result.append(" not a valid action . Please enter \n ");
						result.append("1 for INSERT QUARTER");
						result.append("2 for EJECT QUARTER");
						result.append("3 for PUSH BUTTON for dispensing product");
						response.setHttpStatus(HttpStatus.BAD_REQUEST);
						response.setResult(result.toString());
						return response;
					}
					
				}
				response.setResult(result.toString());
			}
			

		}catch(Exception ex) {

		}

		return response;

	}

}
