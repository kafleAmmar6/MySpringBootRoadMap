package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;


import org.springframework.stereotype.Component;

@Component
public class ChargeUtil {

    public double getPerDayCharge(Long bikeCc) {

        if (bikeCc == null) return 0;

        if (bikeCc == 125) return 500;
        if (bikeCc == 150) return 800;
        if (bikeCc == 200) return 1000;
        if (bikeCc == 250) return 1300;

        return 0;
    }

    public String calculateTotal(Long issuedBikeCc, Double rentalDays) {

        if (rentalDays == null || rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be greater than zero");
        }

        double perDay = getPerDayCharge(issuedBikeCc);
        return "Rs. " + (perDay * rentalDays);
    }
}

