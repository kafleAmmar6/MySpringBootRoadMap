package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class RentalController {

    private final RentalService rentalService;
    private final CustomerService customerService;

    public RentalController(RentalService rentalService, CustomerService customerService) {
        this.rentalService = rentalService;
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public RentalDetail addBikes(@RequestBody RentalDetail rentalDetail) {
        return rentalService.addBikes(rentalDetail);
    }

    @GetMapping("/getall")
    public List<RentalDetail> getAllBikes() {
        return rentalService.getAllBikes();
    }

    @GetMapping("/getbyid/{bikeId}")
    public RentalDetail getBikesById(@PathVariable Integer bikeId) {
        return rentalService.getBikesById(bikeId);
    }

    @PutMapping("/update/id/{bikeId}")
    public RentalDetail updateBikes(@PathVariable Integer bikeId, @RequestBody RentalDetail rentalDetail) {
        return rentalService.updateBikes(bikeId, rentalDetail);
    }

    @DeleteMapping("/delete/id/{bikeId}")
    public RentalDetail deleteBikes(@PathVariable Integer bikeId) {
       return  rentalService.deleteBikes(bikeId);
    }

    @PostMapping("/issue/bikeModel/{bikeModel}")
    public RentalDetail issueBikes( @PathVariable String bikeModel ,@RequestBody CustomerModel customerModel){
        return customerService.issueBikes(bikeModel,customerModel);
    }
}
