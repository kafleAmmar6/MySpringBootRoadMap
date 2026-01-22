package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.RentalDetail;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.RentalRepository;
import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CustomerUtilities customerUtilities;

    public String  issueBikes(Long bikeCc, String bikeModel, String bikeAvailable, CustomerModel customerModel) {
        try {
            RentalDetail exist = rentalRepository.findByBikeCcAndModelAndAvailability(bikeCc, bikeModel, bikeAvailable);
            CustomerModel issue = new CustomerModel();

            issue.setCustomerId(customerModel.getCustomerId());
            issue.setCustomerName(customerModel.getCustomerName());
            issue.setCustomerPhone(customerModel.getCustomerPhone());
            issue.setCustomerAddress(customerModel.getCustomerAddress());

            issue.setIssuedBikeBrand(customerModel.getIssuedBikeBrand());
            issue.setIssuedBikeModel(customerModel.getIssuedBikeModel());
            issue.setIssuedBikeCc(customerModel.getIssuedBikeCc());

            issue.setIssuedDate(LocalDate.now());
            issue.setIssuedTime(LocalTime.now());
            issue.setRentalDurationValid(customerUtilities.rentalDurationValidCheck(
                    customerModel.getRentalDays(),
                    customerModel.getIssuedDate(),
                    customerModel.getIssuedTime()));

            issue.setCustomerTotalRentalCharges(customerUtilities.customerRenatlTotalChargesCheck(
                    customerModel.getRentalDays(),
                    customerModel.getIssuedBikeCc()));

            exist.setBikeAvailable("Not Available");
        }catch( ResourceNotFoundException e){
            throw new ResourceNotFoundException("Bike is Not found");
        }
        return "Sucessfully Bike is Issued";
    }
}
