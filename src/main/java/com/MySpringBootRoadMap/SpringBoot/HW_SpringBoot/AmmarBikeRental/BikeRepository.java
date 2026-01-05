package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.AmmarBikeRental;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BikeRepository extends MongoRepository<BikeModel, String> {

    List<BikeModel> findByAvailability(boolean availability);

    List<BikeModel> findByIssued(boolean issued);
}
