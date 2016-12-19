package com.ice.mongodb.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	/**
	   * This method will find an Customer instance in the database by its name.
	   * Note that this method is not implemented and its working code will be
	   * automatically generated from its signature by Spring Data JPA.
	   */
	 public Customer findByName(String name);

}
