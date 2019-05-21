package com.sample.sodamachine;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.sodamachine.repository.Inventory;
import com.sample.sodamachine.repository.InventoryRepository;
import com.sample.sodamachine.repository.Product;
import com.sample.sodamachine.repository.ProductRepository;
import com.sample.sodamachine.repository.Sales;
import com.sample.sodamachine.repository.SalesRepository;

@SpringBootApplication
public class SodaMachineApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SodaMachineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SodaMachineApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProductRepository prductRepository, InventoryRepository invRespository, SalesRepository salesRepository ) {
		return (args) -> {
			// save a couple of customers
			Product pepsi = new Product("PEPSI", "drink",50);
			Product coke = new Product("COKE", "drink",50);
			Product soda = new Product("SODA", "drink",50);
			Product water = new Product("WATER", "drink",75);
			Product appleJucie = new Product("APPLE JUICE", "drink",75);
			prductRepository.save(pepsi);
			prductRepository.save(coke);
			prductRepository.save(soda);
			prductRepository.save(water);
			prductRepository.save(appleJucie);

			// fetch all products
			log.info("listing all the available products found with findAll():");
			log.info("-------------------------------");
			for (Product product : prductRepository.findAll()) {
				log.info(product.toString());
				
				invRespository.save(new Inventory(product,10));
			}
		
			/*
			 * invRespository.save(new Inventory(pepsi,10)); invRespository.save(new
			 * Inventory(coke,10)); invRespository.save(new Inventory(soda,10));
			 * invRespository.save(new Inventory(water,10)); invRespository.save(new
			 * Inventory(appleJucie,10));
			 */
			
			
			// fetch inventory details
			log.info("listing all the available inventory");
			log.info("-------------------------------");
			for (Inventory inventory : invRespository.findAll()) {
				log.info(inventory.toString());
			}
		
				
			/*
			 * for (Product product : prductRepository.findAll()) {
			 * log.info(product.toString());
			 * 
			 * salesRepository.save(new Sales(product,new Date())); }
			 */
			
		};
	}

}
