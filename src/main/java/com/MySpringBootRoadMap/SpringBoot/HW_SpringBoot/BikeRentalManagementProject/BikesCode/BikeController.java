package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode.Customer;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;
    private final CustomerService customerService;

    public BikeController(BikeService bikeService,
                          CustomerService customerService) {
        this.bikeService = bikeService;
        this.customerService = customerService;
    }

    //  ADMIN ONLY
    @PostMapping("/add")
    public Bike addBike(@RequestBody Bike bike) {
        return bikeService.addBike(bike);
    }

    //  ADMIN + CUSTOMER
    @GetMapping("/get/all")
    public List<Bike> allBikes() {
        return bikeService.getAllBikes();
    }

    //  ADMIN ONLY
    @PutMapping("/update/{bikeId}")
    public Bike update(@PathVariable Integer bikeId,
                       @RequestBody Bike bike) {
        return bikeService.updateBike(bikeId, bike);
    }

    //  ADMIN ONLY
    @DeleteMapping("/delete/{bikeId}")
    public String delete(@PathVariable Integer bikeId) {
        bikeService.deleteBike(bikeId);
        return "Bike deleted successfully";
    }

    //  CUSTOMER + ADMIN
    @PostMapping("/issue")
    public String issueBike(@RequestParam Long bikeCc,
                            @RequestParam String bikeBrand,
                            @RequestParam String bikeModel,
                            @RequestBody Customer customer) {

        return customerService.issueBike(
                bikeCc,
                bikeModel,
                bikeBrand,
                customer
        );
    }

    //  CUSTOMER + ADMIN
    @GetMapping("/return/{customerId}")
    public String returnBike(@PathVariable Integer customerId) {
        return customerService.returnBike(customerId);
    }

    //  ADMIN ONLY
    @GetMapping("/customer/get/all")
    public List<Customer> allCustomer() {
        return customerService.getAllCustomer();
    }
}

