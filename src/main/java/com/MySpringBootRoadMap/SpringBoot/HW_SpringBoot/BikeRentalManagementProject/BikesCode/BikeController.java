package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode.Customer;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PostMapping("/add")
    public Bike addBike(@RequestBody Bike bike) {
        return bikeService.addBike(bike);
    }

    @GetMapping("/all")
    public List<Bike> allBikes() {
        return bikeService.getAllBikes();
    }

    @PutMapping("/update/{id}")
    public Bike update(@PathVariable Integer id,
                       @RequestBody Bike bike) {
        return bikeService.updateBike(id, bike);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bikeService.deleteBike(id);
        return "Bike deleted successfully";
    }

    // ISSUE BIKE
    @PostMapping("/issue/bikeCc/{}bikeCc/bikeBrand/{bikeBrand}/bikeModel/{bikeModel}/bikeStatus/{bikeStatus}")
    public String issueBike(@PathVariable Long bikeCc,
                            @PathVariable String bikeBrand,
                            @PathVariable String bikeModel,
                            @PathVariable String bikeStatus,
                            @RequestBody Customer customer) {

        return customerService.issueBike(bikeCc,bikeBrand, bikeModel,bikeStatus, customer);
    }
}
