package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // UPDATE BIKES BY BIKEID
    public RentalDetail updateBikes(Integer bikeId, RentalDetail rentalDetail) {
        RentalDetail existBike = rentalRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bike not found with ID: " + bikeId));

        existBike.setBikeId(rentalDetail.getBikeId());
        existBike.setBikeModel(rentalDetail.getBikeModel());
        existBike.setBikeBrand(rentalDetail.getBikeBrand());
        existBike.setBikeCc(rentalDetail.getBikeCc());

        return rentalRepository.save(existBike);
    }

    // DELETE BIKES BY BIKEID
    public RentalDetail deleteBikes(Integer bikeId) {
        // Check if bike exists before deleting
        RentalDetail existBike = rentalRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new ResourceNotFoundException("Bike not found with ID: " + bikeId));
       return  rentalRepository.deleteByBikeId(bikeId);
    }
}
