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
    public String issueBike(Long bikeCc,
                            String bikeModel,
                            String bikeBrand,
                            Customer customer) {

        //  DO NOT take bikeStatus from request
        Bike bike = bikeRepository
                .findByBikeCcAndBikeBrandAndBikeModelAndBikeStatus(
                        bikeCc,
                        bikeBrand,
                        bikeModel,
                        "Available"
                )
                .orElseThrow(() -> new NotFoundException("Bike not available"));

        // set issued bike info
        customer.setIssuedbikeBrand(bikeBrand);
        customer.setIssuedbikeModel(bikeModel);
        customer.setIssuedbikeCc(bikeCc);

        customer.setIssuedDate(LocalDate.now());
        customer.setIssuedTime(LocalTime.now());

        customer.setTotalCharge(
                chargeUtil.calculateTotal(bikeCc, customer.getRentalDays())
        );

        // update bike status
        bike.setBikeStatus("Not Available");

        bikeRepository.save(bike);
        customerRepository.save(customer);

        return customer.getCustomerId() +
                customer.getCustomerName() +
                customer.getCustomerAddress() +
                customer.getCustomerPhone() +
                customer.getIssuedbikeCc() +
                customer.getIssuedbikeBrand() +
                customer.getIssuedbikeModel() +
                customer.getRentalDays() +
                customer.getIssuedDate() +
                customer.getIssuedTime() +
                customer.getTotalCharge() +
                "Bike issued successfully";
    }
}
