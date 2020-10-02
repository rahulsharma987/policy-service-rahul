package com.rs.training.policyservice.rs.service;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rs.training.policyservice.rs.model.Customer;

@Service
public class CustomerService {

	public Customer getCustomerDetails(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> response = restTemplate.getForEntity("http://localhost:8081/mongoCustomer/"+customerId, Customer.class);
		Customer customer = response.getBody();
		return customer;
	}
	
	public Customer getExchangeCustomerDetails(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8081/mongoCustomer/" + customerId,
				HttpMethod.GET, requestEntity, Customer.class);
		Customer customer = response.getBody();
		return customer;
	}

	public Customer getObjectCustomerDetails(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject("http://localhost:8081/mongoCustomer/" + customerId,
				Customer.class);
		return customer;
	}


}
