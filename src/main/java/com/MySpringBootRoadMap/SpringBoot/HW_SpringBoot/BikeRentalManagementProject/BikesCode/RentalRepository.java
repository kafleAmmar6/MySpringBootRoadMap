package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface RentalRepository extends MongoRepository<RentalDetail, String> {

    // Find a bike by bikeId
    @Query("{ 'bikeId': ?0 }")
    Optional<RentalDetail> findByBikeId(Integer bikeId);

    // Delete a bike by bikeId
    @Query("{ 'bikeId': ?0 }")
    public RentalDetail deleteByBikeId(Integer bikeId);

    //FIND BIKE BY CC
    @Query("{ 'bikeCc': ?0 }")
    public RentalDetail findByBikeCc(Long bikeCc);

    //FIND BIKE BY MODEL
    @Query("{ 'bikeModel': ?0 }")
    public RentalDetail findByBikeModel(String bikeModel);

    //FIND BIKE BY AVAILABILITY
    @Query("{ 'bikeAvailable': ?0 }")
    public RentalDetail findByBikeAvailability(String bikeAvailable);

}
