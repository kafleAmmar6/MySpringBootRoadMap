package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomerUtilities {

    @Autowired
    private CustomerModel customerModel;
    public LocalDateTime rentalDurationValidCheck(Double rentalDays , LocalDate issuedDate , LocalTime issuedTime) {

         Double allowedRentalDays = customerModel.getRentalDays();
        LocalDate allowedIssuedDate = customerModel.getIssuedDate();   // yyyy-MM-dd
        LocalTime allowedIssuedTime = customerModel.getIssuedTime();   // HH:mm

        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();


        return null;
    }

}
