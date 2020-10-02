package com.rs.training.policyservice.rs.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rs.training.policyservice.rs.model.Policy;
import com.rs.training.policyservice.rs.service.PolicyService;

@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policyService;

	@RequestMapping("/hello")
	public String hello() {
		return "Greetings from Spring Boot Policy Application 1.0";
	}
	
	@RequestMapping(value="/createPolicy", method = RequestMethod.POST)
	public Policy createPolicy(@RequestBody Policy policy) {
		return policyService.createPolicy(policy);
		
	}
	
	@RequestMapping(value="/policies", method = RequestMethod.GET)
	public List<Policy> getPolicies(){
		return policyService.getPolicies();
	}
	
	@RequestMapping(value = "/createExchangePolicy", method = RequestMethod.POST)
	public Policy createExchangePolicy(@RequestBody Policy policy) {
		return policyService.createExchangePolicy(policy);
	}
	
	@RequestMapping(value = "/createObjectPolicy", method = RequestMethod.POST)
	public Policy createObjectPolicy(@RequestBody Policy policy) {
		return policyService.createObjectPolicy(policy);
	}
}
