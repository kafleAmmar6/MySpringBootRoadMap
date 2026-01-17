package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
