package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface BikeRepository extends MongoRepository<Bike, Integer> {

    Optional<Bike> findByBikeId(Integer bikeId);

    Optional<Bike> findByBikeCcAndBikeBrandAndBikeModelAndBikeStatus(
            Long bikeCc,String bikeBrand, String bikeModel, String bikeStatus);

    void deleteByBikeId(Integer bikeId);
}
