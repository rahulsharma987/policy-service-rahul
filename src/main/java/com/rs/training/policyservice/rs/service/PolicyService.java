package com.rs.training.policyservice.rs.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rs.training.policyservice.rs.model.Customer;
import com.rs.training.policyservice.rs.model.Policy;
import com.rs.training.policyservice.rs.repository.PolicyRepository; 


@Service
public class PolicyService {
	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	CustomerService customerService;

	public Policy createPolicy(Policy policy) {
		Customer customer;
		customer = customerService.getCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}

	public List<Policy> getPolicies() {
		return policyRepository.findAll();
	}
	
	public Policy createExchangePolicy(Policy policy) {
		Customer customer;
		customer = customerService.getExchangeCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}
	
	public Policy createObjectPolicy(Policy policy) {
		Customer customer;
		customer = customerService.getObjectCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}

}
