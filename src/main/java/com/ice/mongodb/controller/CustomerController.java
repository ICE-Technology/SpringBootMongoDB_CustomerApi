package com.ice.mongodb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ice.mongodb.models.Customer;
import com.ice.mongodb.models.CustomerRepository;

	/**
	 * @author Shyam Kishor
	 *
	 */
	@RestController
	@RequestMapping("/customer")
	public class CustomerController {
		
		@Autowired
		CustomerRepository customerRepository;
		/**
		 * GET /create  --> Create a new customer and save it in the database.
		 */
		@RequestMapping("/create")
		public Map<String, Object> create(Customer customer) {
			
			customer = customerRepository.save(customer);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("message", "Customer Details created successfully");
			dataMap.put("status", "1");
			dataMap.put("Customer", customer);
		    return dataMap;
		}
		/**
		 * GET /read  --> Read a Customer Details by Customer id from the database.
		 */
		@RequestMapping("/read")
		public Map<String, Object> read(@RequestParam String customerId) {
			Customer customer = customerRepository.findOne(customerId);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("message", "Customer found successfully");
			dataMap.put("status", "1");
			dataMap.put("customer", customer);
		    return dataMap;
		}
		
		/**
		 * GET /update  --> Update a customer record and save it in the database.
		 */
		@RequestMapping("/update")
		public Map<String, Object> update(@RequestParam String customerId, @RequestParam String name) {
			Customer customer = customerRepository.findOne(customerId);
			customer.setName(name);
			customer = customerRepository.save(customer);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("message", "Customer Details updated successfully");
			dataMap.put("status", "1");
			dataMap.put("customer", customer);
		    return dataMap;
		}
		
		/**
		 * GET /delete  --> Delete a customer from the database.
		 */
		@RequestMapping("/delete")
		public Map<String, Object> delete(@RequestParam String customerId) {
			customerRepository.delete(customerId);
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("message", "customer deleted successfully test comment");
			dataMap.put("status", "1");
		    return dataMap;
		}
		
		/**
		 * GET /read  --> Read all Customers from the database.
		 */
		@RequestMapping("/read-all")
		public Map<String, Object> readAll() {
			List<Customer> customers = customerRepository.findAll();
			Map<String, Object> dataMap = new HashMap<String, Object>();
			dataMap.put("message", "Customer found successfully");
			dataMap.put("totalCustomer", customers.size());
			dataMap.put("status", "1");
			dataMap.put("customers",customers);
		    return dataMap;
		}

}
