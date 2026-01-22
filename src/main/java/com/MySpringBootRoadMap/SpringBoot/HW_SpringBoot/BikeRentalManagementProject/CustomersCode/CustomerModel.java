package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="RENTAL ISSUE DATA")
@Component
public class CustomerModel {

    //CUSTOMER DETAIL
    @Id
    private Integer customerId;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    //BIKE DETAIL
    private String issuedBikeModel;
    private String issuedBikeBrand;
    private Long issuedBikeCc;
    //DATE AND TIME OF ISSUED
    private Double rentalDays;
    private LocalDate issuedDate;
    private LocalTime issuedTime;
    private String  rentalDurationValid;
   //TOTAL CHARGES FOR CUSTOMER
    private String customerTotalRentalCharges;
}
