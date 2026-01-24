package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
