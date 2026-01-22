package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
@Component
public class CustomerUtilities {

    @Autowired
    private CustomerModel customerModel;

    public String  rentalDurationValidCheck(Double rentalDays, LocalDate issuedDate, LocalTime issuedTime) {
        // 1. Combine issued date and time
        LocalDateTime issuedDateTime =
                LocalDateTime.of(issuedDate, issuedTime);
        // 2. Convert rental days to hours (1 day = 24 hours)
        long rentalHours = (long) (rentalDays * 24);
        // 3. Calculate expiry date & time
        LocalDateTime expiryDateTime =
                issuedDateTime.plusHours(rentalHours);
        // 4. Get current date & time
        LocalDateTime nowDateTime = LocalDateTime.now();
        // 5. Check if rental is expired or valid
        if (nowDateTime.isAfter(expiryDateTime)) {
            return   (" Rental period expired on : " + expiryDateTime);
        } else {
            return (" Rental period still valid till : " + expiryDateTime);
        }
    }

    public String customerRenatlTotalChargesCheck(Double rentalDays, Long issuedBikeCc) {
        // BIKE CC TYPES
        Integer firstCc = 125;
        Integer secondCc = 150;
        Integer thirdCc = 160;
        Integer fourthCc = 180;
        Integer fifthCc = 200;
        Integer sixthCc = 220;
        Integer seventhCc = 390;
        Integer eighthCc = 400;
        // BIKE CC DAILY CHARGES
        Double firstCcCharges = 500d;
        Double secondCcCharges = 800d;
        Double thirdCcCharges = 1100d;
        Double fourthCcCharges = 1500d;
        Double fifthCcCharges = 1800d;
        Double sixthCcCharges = 2100d;
        Double seventhCcCharges = 2500d;
        Double eighthCcCharges = 2800d;
        // This will store per-day charge
        Double perDayCharge = 0.0;
        // CHECK BIKE CC AND SET CHARGE
        if (issuedBikeCc.equals(firstCc.longValue())) {
            perDayCharge = firstCcCharges;
        }
        else if (issuedBikeCc.equals(secondCc.longValue())) {
            perDayCharge = secondCcCharges;
        }
        else if (issuedBikeCc.equals(thirdCc.longValue())) {
            perDayCharge = thirdCcCharges;
        }
        else if (issuedBikeCc.equals(fourthCc.longValue())) {
            perDayCharge = fourthCcCharges;
        }
        else if (issuedBikeCc.equals(fifthCc.longValue())) {
            perDayCharge = fifthCcCharges;
        }
        else if (issuedBikeCc.equals(sixthCc.longValue())) {
            perDayCharge = sixthCcCharges;
        }
        else if (issuedBikeCc.equals(seventhCc.longValue())) {
            perDayCharge = seventhCcCharges;
        }
        else if (issuedBikeCc.equals(eighthCc.longValue())) {
            perDayCharge = eighthCcCharges;
        }
        else {
            return "Invalid Bike CC";
        }
        // CALCULATE TOTAL AMOUNT
        Double totalAmount = perDayCharge * rentalDays;
        // RETURN RESULT
        return "Total rental charge is: Rs. " + totalAmount;
    }
}


