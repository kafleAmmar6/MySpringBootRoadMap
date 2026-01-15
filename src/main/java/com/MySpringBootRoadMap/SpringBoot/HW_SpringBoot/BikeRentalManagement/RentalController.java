package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService rentalService;
    private final CustomerService customerService;

    public RentalController(RentalService rentalService, CustomerService customerService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
    }

    // CREATE rental with customer info in headers
    @PostMapping("/add")
    public RentalDetail createRental(
            @RequestBody RentalDetail rentalDetail,
            @RequestHeader("customerId") String customerId,
            @RequestHeader("customerName") String customerName,
            @RequestHeader("customerNumber") String customerNumber,
            @RequestHeader("customerEmail") String customerEmail
    ) {
        // Save customer
        CustomerDetail customer = new CustomerDetail(customerId, customerName, customerNumber, customerEmail);
        customerService.saveCustomer(customer);

        // Save rental
        return rentalService.createRental(rentalDetail);
    }

    // GET all rentals
    @GetMapping("/showallbike")
    public List<RentalDetail> getAllRentals() {
        return rentalService.getAllRentals();
    }

    // GET rental by ID
    @GetMapping("/id/{id}")
    public RentalDetail getRentalById(@PathVariable("id") String bikeId) {
        return rentalService.getRentalById(bikeId);
    }

    // UPDATE rental by ID
    @PutMapping("/update/id/{id}")
    public RentalDetail updateRental(
            @PathVariable("id") String bikeId,
            @RequestBody RentalDetail rentalDetail) {
        return rentalService.updateRental(bikeId, rentalDetail);
    }

    // DELETE rental by ID
    @DeleteMapping("/delete/id/{id}")
    public String deleteRental(@PathVariable("id") String bikeId) {
        rentalService.deleteRental(bikeId);
        return "Rental deleted successfully";
    }

    // ISSUE a rental (change status to RENTED)
    @GetMapping("/issue/{id}")
    public RentalDetail issueRental(@PathVariable("id") String bikeId) {
        return rentalService.issueRental(bikeId);
    }

    // GET all customers
    @GetMapping("/showallcustomer")
    public List<CustomerDetail> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
