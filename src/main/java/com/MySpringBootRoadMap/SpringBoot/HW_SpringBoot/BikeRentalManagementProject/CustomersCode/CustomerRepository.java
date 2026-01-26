package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

    Optional<Customer> findByCustomerId(Integer customerId);

    void deleteByCustomerId(Integer customerId);
}
