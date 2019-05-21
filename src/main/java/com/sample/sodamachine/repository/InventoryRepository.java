package com.sample.sodamachine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory,Integer>{

	public List<Inventory> findByProduct(Product Product);
}
