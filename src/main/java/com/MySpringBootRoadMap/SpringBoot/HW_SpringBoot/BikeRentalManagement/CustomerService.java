package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    // In-memory customer list (beginner-friendly)
    private final List<CustomerDetail> customerList = new ArrayList<>();

    // Save customer
    public CustomerDetail saveCustomer(CustomerDetail customer) {
        customerList.add(customer);
        return customer;
    }

    // Get all customers
    public List<CustomerDetail> getAllCustomers() {
        return customerList;
    }
}
