package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Bikes")
public class RentalDetail {

    // BIKE DETAILS
    @Id
    private Integer bikeId;
    private String bikeModel;
    private String bikeBrand;
    private String bikeStatus;
}
