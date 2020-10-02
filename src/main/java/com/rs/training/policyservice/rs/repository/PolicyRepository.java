package com.rs.training.policyservice.rs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rs.training.policyservice.rs.model.Policy;

public interface PolicyRepository extends MongoRepository<Policy, String>{

}
