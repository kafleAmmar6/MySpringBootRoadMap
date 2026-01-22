package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode.CustomerModel;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode.CustomerService;
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

    @PutMapping("/update/bikeId/{bikeId}")
    public RentalDetail updateBikes(@PathVariable Integer bikeId, @RequestBody RentalDetail rentalDetail) {
        return rentalService.updateBikes(bikeId, rentalDetail);
    }

    @DeleteMapping("/delete/id/{bikeId}")
    public RentalDetail deleteBikes(@PathVariable Integer bikeId) {
       return  rentalService.deleteBikes(bikeId);
    }

    @PostMapping("/issue/bikeCc/{bikeCc}/bikeModel/{bikeModel}/bikeAvailable/{bikeAvailable}")
    public String issueBikes(
            @PathVariable Long bikeCc,
            @PathVariable String  bikeModel,
            @PathVariable String bikeAvailable,
            @RequestBody CustomerModel customerModel){
        return customerService.issueBikes(bikeCc,bikeModel,bikeAvailable,customerModel);
    }
}
