package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.AmmarBikeRental;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    // Add bike
    public BikeModel addBike(BikeModel bike) {
        bike.setAvailability(true);
        bike.setIssued(false);
        return bikeRepository.save(bike);
    }

    // Get all bikes
    public List<BikeModel> getAllBikes() {
        return bikeRepository.findAll();
    }

    // Issue bike
    public BikeModel issueBike(String bikeId, String issuedTo, String contactNumber) {

        BikeModel bike = bikeRepository.findById(bikeId)
                .orElseThrow(() -> new BikeException("Bike not found"));

        if (!bike.isAvailability()) {
            throw new BikeException("Bike is already issued");
        }

        bike.setIssued(true);
        bike.setAvailability(false);
        bike.setIssuedTo(issuedTo);
        bike.setContactNumber(contactNumber);
        bike.setIssueTime(LocalDateTime.now());

        return bikeRepository.save(bike);
    }

    // Return bike
    public BikeModel returnBike(String bikeId) {

        BikeModel bike = bikeRepository.findById(bikeId)
                .orElseThrow(() -> new BikeException("Bike not found"));

        bike.setIssued(false);
        bike.setAvailability(true);
        bike.setIssuedTo(null);
        bike.setContactNumber(null);
        bike.setReturnTime(LocalDateTime.now());

        return bikeRepository.save(bike);
    }
}
