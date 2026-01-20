package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.BikesCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "BIKES DATA")
public class RentalDetail {

    // BIKE DETAILS
    @Id
    private Integer bikeId;
    private Long bikeCc;
    private String bikeModel;
    private String bikeBrand;
    private String bikeInsuranceType;
    private LocalDate bikeInsuranceValid;
    private String bikeAvailable;
}
