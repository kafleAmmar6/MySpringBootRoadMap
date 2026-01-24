package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike addBike(Bike bike) {
        bike.setBikeStatus("Available");
        return bikeRepository.save(bike);
    }

    public List<Bike> getAllBikes() {
        return bikeRepository.findAll();
    }

    public Bike updateBike(Integer bikeId, Bike bike) {
        Bike oldBike = bikeRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new NotFoundException("Bike not found"));

        oldBike.setBikeId(bike.getBikeId());
        oldBike.setBikeBrand(bike.getBikeBrand());
        oldBike.setBikeModel(bike.getBikeModel());
        oldBike.setBikeCc(bike.getBikeCc());
        oldBike.setBikeStatus(bike.getBikeStatus());

        return bikeRepository.save(oldBike);
    }

    public void deleteBike(Integer bikeId) {
        bikeRepository.findByBikeId(bikeId)
                .orElseThrow(() -> new NotFoundException("Bike not found"));
        bikeRepository.deleteByBikeId(bikeId);
    }
}
