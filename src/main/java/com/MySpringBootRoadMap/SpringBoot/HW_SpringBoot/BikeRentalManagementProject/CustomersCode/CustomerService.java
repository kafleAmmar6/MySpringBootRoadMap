package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.Bike;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.BikeRepository;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final BikeRepository bikeRepository;
    private final ChargeUtil chargeUtil;

    public CustomerService(CustomerRepository customerRepo,
                           BikeRepository bikeRepo,
                           ChargeUtil chargeUtil) {
        this.customerRepository = customerRepo;
        this.bikeRepository = bikeRepo;
        this.chargeUtil = chargeUtil;
    }

    // ISSUE BIKE
    public String issueBike(Long bikeCc, String bikeModel, String bikeBrand, String bikeStatus, Customer customer) {

        Bike bike = bikeRepository
                .findByBikeCcAndBikeBrandAndBikeModelAndBikeStatus(bikeCc,bikeBrand, bikeModel,bikeStatus)
                .orElseThrow(() -> new NotFoundException("Bike not available"));

        customer.setCustomerId(customer.getCustomerId());
       customer.setCustomerName(customer.getCustomerName());
       customer.setCustomerAddress(customer.getCustomerAddress());
       customer.setCustomerPhone(customer.getCustomerPhone());

       customer.setIssuedbikeBrand(bikeBrand);
       customer.setIssuedbikeModel(bikeModel);
       customer.setIssuedbikeCc(bikeCc);

       customer.setRentalDays(customer.getRentalDays());
        customer.setIssuedDate(LocalDate.now());
        customer.setIssuedTime(LocalTime.now());

        customer.setTotalCharge(
                chargeUtil.calculateTotal(customer.getIssuedbikeCc(),customer.getRentalDays()));

        bike.setBikeStatus("Not Available");

        bikeRepository.save(bike);
        customerRepository.save(customer);

        return "Bike issued successfully";
    }

}
