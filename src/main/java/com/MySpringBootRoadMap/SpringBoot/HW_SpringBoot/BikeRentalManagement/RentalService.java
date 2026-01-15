package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // CREATE rental
    public RentalDetail createRental(RentalDetail rentalDetail) {
        if (rentalDetail.getBikeStatus() == null) {
            rentalDetail.setBikeStatus("AVAILABLE");
        }
        return rentalRepository.save(rentalDetail);
    }

    // READ all rentals
    public List<RentalDetail> getAllRentals() {
        return rentalRepository.findAll();
    }

    // READ by bikeId
    public RentalDetail getRentalById(String bikeId) {
        return rentalRepository.findById(bikeId)
                .orElseThrow(() -> new RuntimeException("Rental not found with id: " + bikeId));
    }

    // UPDATE rental
    public RentalDetail updateRental(String bikeId, RentalDetail rentalDetail) {
        RentalDetail existing = getRentalById(bikeId);
        existing.setBikeModel(rentalDetail.getBikeModel());
        existing.setBikeBrand(rentalDetail.getBikeBrand());
        existing.setBikeRentalDay(rentalDetail.getBikeRentalDay());
        existing.setBikeTotalRentalPrice(rentalDetail.getBikeTotalRentalPrice());
        existing.setBikeStatus(rentalDetail.getBikeStatus());
        return rentalRepository.save(existing);
    }

    // DELETE rental
    public void deleteRental(String bikeId) {
        rentalRepository.delete(getRentalById(bikeId));
    }

    // ISSUE rental
    public RentalDetail issueRental(String bikeId) {
        RentalDetail rental = getRentalById(bikeId);
        if ("RENTED".equalsIgnoreCase(rental.getBikeStatus())) {
            throw new RuntimeException("Bike already rented");
        }
        rental.setBikeStatus("RENTED");
        return rentalRepository.save(rental);
    }
}
