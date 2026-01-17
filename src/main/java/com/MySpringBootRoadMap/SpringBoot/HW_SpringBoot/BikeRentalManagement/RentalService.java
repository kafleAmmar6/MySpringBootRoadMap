package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    // ADD BIKES
    public RentalDetail addBikes(RentalDetail rentalDetail) {
        return rentalRepository.save(rentalDetail);
    }

    // GET ALL BIKES
    public List<RentalDetail> getAllBikes() {
        return rentalRepository.findAll();
    }

    // GET BIKES BY BIKEID
    public RentalDetail getBikesById(Integer bikeId) {
        return rentalRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bike not found with ID: " + bikeId));
    }

    // UPDATE BIKES BY BIKEID
    public RentalDetail updateBikes(Integer bikeId, RentalDetail rentalDetail) {
        RentalDetail existBike = rentalRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bike not found with ID: " + bikeId));

        existBike.setBikeId(rentalDetail.getBikeId());
        existBike.setBikeModel(rentalDetail.getBikeModel());
        existBike.setBikeBrand(rentalDetail.getBikeBrand());
        existBike.setBikeStatus(rentalDetail.getBikeStatus());

        return rentalRepository.save(existBike);
    }

    // DELETE BIKES BY BIKEID
    public void deleteBikes(Integer bikeId) {
        // Check if bike exists before deleting
        RentalDetail existBike = rentalRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bike not found with ID: " + bikeId));
        rentalRepository.deleteByBikeId(bikeId);
    }
}
