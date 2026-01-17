package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RentalRepository extends MongoRepository<RentalDetail, String> {

    // Find a bike by bikeId
    Optional<RentalDetail> findByBikeId(Integer bikeId);

    // Delete a bike by bikeId
    public void deleteByBikeId(Integer bikeId);
}
