package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.AmmarBikeRental;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;

    // Constructor Injection
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    // Add a new bike
    @PostMapping("/add")
    public ResponseEntity<BikeResponse> addBike(@RequestBody BikeModel bikeModel) {
        BikeModel savedBike = bikeService.addBike(bikeModel);
        return ResponseEntity.ok(
                new BikeResponse("Bike added successfully", savedBike)
        );
    }

    // Get all bikes
    @GetMapping("/all")
    public ResponseEntity<BikeResponse> getAllBikes() {
        List<BikeModel> bikes = bikeService.getAllBikes();
        return ResponseEntity.ok(
                new BikeResponse("All bikes fetched", bikes)
        );
    }

    // Issue a bike
    @PutMapping("/issue/{bikeId}")
    public ResponseEntity<BikeResponse> issueBike(
            @PathVariable String bikeId,
            @RequestParam String issuedTo,
            @RequestParam String contactNumber) {

        BikeModel bike = bikeService.issueBike(bikeId, issuedTo, contactNumber);
        return ResponseEntity.ok(
                new BikeResponse("Bike issued successfully", bike)
        );
    }

    // Return a bike
    @PutMapping("/return/{bikeId}")
    public ResponseEntity<BikeResponse> returnBike(@PathVariable String bikeId) {
        BikeModel bike = bikeService.returnBike(bikeId);
        return ResponseEntity.ok(
                new BikeResponse("Bike returned successfully", bike)
        );
    }
}

